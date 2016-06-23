package com.zmax.allsamples.Media.Image;
/**
 * Created by Kasturi on 03-May-16.
 */
public class Image
{
    //Camera and Gallery with rotate 90 degree option
    //http://stackoverflow.com/questions/11732872/android-how-can-i-call-camera-or-gallery-intent-together

    //Create folder and save image and sync in app gallery

            //  1)     http://stackoverflow.com/questions/25217495/download-images-from-url-to-sd-card
            //  2)     http://stackoverflow.com/questions/18010739/android-save-images-in-an-specific-folder
    // Camera and picker dialog
            //  3)     http://www.theappguruz.com/blog/android-take-photo-camera-gallery-code-sample

    //Fetch the data from particular folder and list in grid or list view

                        /*private void LoadDataOnGridView()
                        {
                            if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
                            {
                                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                // Locate the image folder in your SD Card
                                file = new File(Environment
                                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),IConstant._FolderName);
                                // Create a new folder if no folder named SDImageTutorial exist
                                file.mkdirs();
                            }

                            if (file.isDirectory())
                            {
                                listFile = file.listFiles();
                                // Create a String array for FilePathStrings
                                FilePathStrings = new String[listFile.length];
                                // Create a String array for FileNameStrings
                                FileNameStrings = new String[listFile.length];

                                for (int i = 0; i < listFile.length; i++)
                                {
                                    // Get the path of the image file
                                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                                    // Get the name image file
                                    FileNameStrings[i] = listFile[i].getName();
                                }
                                MDAdapter = new Material_DownLoad_adapter(ctx,FilePathStrings, FileNameStrings);
                                gridview.setAdapter(MDAdapter);
                            }

                        }*/



    /*Camera and Gal responce*/

    /*camera   file:///mnt------/storage/emulated/0/1466082494783.jpg

    content://com.android.providers.media.documents/document/image%3A8214



        "http://site.com/image.png" // from Web
        "file:///mnt/sdcard/image.png" // from SD card
        "file:///mnt/sdcard/video.mp4" // from SD card (video thumbnail)
        "content://media/external/images/media/13" // from content provider
        "content://media/external/video/media/13" // from content provider (video thumbnail)
        "assets://image.png" // from assets
        "drawable://" + R.drawable.img // from drawables (non-9patch images)*/
}
