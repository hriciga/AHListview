# AHListview
Example code of Android app using ListView with the CustomAdapter. 
ListView contains image, title and text. 
I am publishing the code for the learning purposes of beginner programmers. 
ListView is populated from strings.xml to make easier the translation of the app into other languages. 
This is what I have been missing in other code examples.
Image is rounded with de.hdodenhof:circleimageview library. Thank you.
DataItem class contains blueprint for our title, text, image object.
To pass position of the array to DetailActivity, intent.putExtra and in receiving activity getIntent().getStringExtra is used.
