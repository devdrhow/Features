import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.choward.features.R
import com.choward.features.databinding.FeaturesItemLayoutBinding
import com.choward.features.model.remote.FeaturesBusiness
import com.choward.features.model.remote.FeaturesResponse
import com.squareup.picasso3.Picasso
import kotlin.coroutines.coroutineContext

private const val TAG = "FeaturesAdapter"
class FeaturesAdapter(private val dataSet: FeaturesResponse): RecyclerView.Adapter<ViewHolder>(){

    class FeaturesViewHolder(private val binding: FeaturesItemLayoutBinding):ViewHolder(binding.root){

        fun bind(currentElement: FeaturesBusiness){
            binding.apply {
                binding.root.setOnClickListener {
                    Toast.makeText(binding.root.context, "A business was clicked ${tvCompanyTitle.text}", Toast.LENGTH_SHORT).show()
                }
                tvCompanyTitle.text = currentElement.name
                if(currentElement.location.address2.isNullOrBlank()){
                    tvStreetAddressLine.text = currentElement.location.address1
                    tvCityZipStateLine.text = currentElement.location.city + ", " +
                            currentElement.location.state + ", " +currentElement.location.zip_code
                }
                else {
                    tvStreetAddressLine2.visibility = View.VISIBLE
                    tvStreetAddressLine.text = currentElement.location.address1
                    tvStreetAddressLine2.text = currentElement.location.address2
                    tvCityZipStateLine.text = currentElement.location.city + ", " +
                            currentElement.location.state + ", " +currentElement.location.zip_code

                }



                ivFeaturesReview.setImageResource(R.drawable.star_rate)
                tvRatingNumber.text = currentElement.rating.toString()

                


                Picasso.Builder(binding.root.context)
                    .build()
                    .load(currentElement.image_url.replace("http:","https:")).resize(200,200)
                    .into(binding.ivFeatCompanyImage)

            }
        }
    }

    class NoInternetViewHolder(private val view: View):ViewHolder(view){
        fun onBind(){
            throw Exception("")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            0 -> {
                FeaturesViewHolder(
                    FeaturesItemLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            1 -> {
                NoInternetViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        android.R.layout.simple_list_item_1, parent, false
                    )
                )
            }
            else -> throw Exception("Incorrect ViewHolder")
        }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        when (holder){
            is FeaturesViewHolder -> {dataSet?.let {
                Log.d(TAG, "onBindViewHolder: viewholder")
                holder.bind(dataSet.businesses[position])
            }}
            is NoInternetViewHolder -> {
                holder.onBind()
            }
        }
    }

    override fun getItemCount() = dataSet.businesses.size
}