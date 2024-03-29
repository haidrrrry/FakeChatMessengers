package com.codecue.fakechatmessengers.activities

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codecue.fakechatmessengers.*
import com.codecue.fakechatmessengers.databinding.ActivityAddNewUserBinding
import com.codecue.fakechatmessengers.databinding.ActivityCurrentUserImageBinding

class CurrentUserImage : AppCompatActivity() {
    private lateinit var binding: ActivityCurrentUserImageBinding
    private val SELECT_IMAGE_CODE = 100
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrentUserImageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        databaseHelper = DatabaseHelper(this)
        setOnClickListeners()

    }

    private fun setOnClickListeners() {

        binding.currentUserImageView.setOnClickListener { pickImage() }

        binding.backButton.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        binding.saveImageButton.setOnClickListener { saveImage() }

    }

    private fun saveImage() {

        val getImageFromView = (binding.currentUserImageView.drawable as BitmapDrawable).bitmap
        val convertedImage: ByteArray = DbBitmapUtility.getBytes(getImageFromView)


        val isInserted: Boolean = databaseHelper.insertUserImage(convertedImage)
        databaseHelper.close()

        if (isInserted) {
            startActivity(Intent(this, ChatListActivity::class.java))
            this.finish()

        } else {
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()
        }

    }


    /** FUN: Pick Image From Device And Set Image To An ImageView **/

    private fun pickImage() {

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent, "Choose Picture"), SELECT_IMAGE_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SELECT_IMAGE_CODE && resultCode == RESULT_OK) {

            val profileImageURI = data?.data

            if (profileImageURI?.let {
                    ImageLengthFinder.getLength(
                        this@CurrentUserImage,
                        it
                    )
                } != null &&
                ImageLengthFinder.getLength(this@CurrentUserImage, profileImageURI)!! > 1200) {

                // ErrorBottomSheet.loadSheet(this@CreateShopActivity, "Image size must be less than 1 MB.")
                Toast.makeText(this, "Image Size Is Too Large ", Toast.LENGTH_LONG).show()

                return@onActivityResult
            }

            binding.currentUserImageView.setImageURI(data?.data)

        }
    }


}