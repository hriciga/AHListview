# AHListview
Example code of Android app using ListView with the CustomAdapter. I am publishing the code for the learning purposes of beginner programmers. 
ListView contains image and title. 
ListView is populated from strings.xml array to make easier the translation of the app into other languages and this is what I have been missing in other code examples.
Image is rounded with de.hdodenhof:circleimageview library. Thank you!

DataItem class contains blueprint for our title, text, image object.

To pass position of the array from MainActivity to DetailActivity, intent.putExtra and in the receiving detail activity getIntent().getStringExtra is used.

How the app looks:

MainActivity

![Image of Yaktocat](https://github.com/hriciga/AHListview/blob/master/app/src/main/res/drawable/Screenshot_1593031690.png)

and DetailActivity

![Image of Yaktocat](https://github.com/hriciga/AHListview/blob/master/app/src/main/res/drawable/Screenshot_1593031705.png)
