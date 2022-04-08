package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SamanyaPrarthanaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Versions> versionsList;

    TextView language_dialog,helloworldtext;
    boolean lang_selected=true;
    Context context;
    Resources resources;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prarthana);



        getSupportActionBar().setTitle(" सामान्य प्रार्थना");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        language_dialog = (TextView)findViewById(R.id.dialog_language);
        helloworldtext = (TextView)findViewById(R.id.textview);


//
//        language_dialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//             final String[] language ={"English","मराठी "};
//
//             int checkItem;
//
//             if(lang_selected)
//             {
//                 checkItem=0;
//
//             }
//             else {
//                 checkItem=1;
//
//             }
//
//
//           final AlertDialog.Builder builder=new AlertDialog.Builder(PrarthanaActivity.this);
//             builder.setTitle("select a language")
//                     .setSingleChoiceItems(language, checkItem, new DialogInterface.OnClickListener() {
//                         @Override
//                         public void onClick(DialogInterface dialogInterface, int i) {
//
//                             language_dialog.setText(language[i]);
//
//                             if(language[i].equals("English"))
//                             {
//
//                                 initData();
//                                 setRecyclerView();
//                                 context = LocalHelper.setLocale(PrarthanaActivity.this,"en");
//                                 resources=context.getResources();
//                                 helloworldtext.setText(resources.getString(R.string.language));
//
//                             }
//
//                             if(language[i].equals("मराठी "))
//                             {
//
//                                 initData2();
//                                 setRecyclerView2();
//                                 context = LocalHelper.setLocale(PrarthanaActivity.this,"hi");
//                                 resources=context.getResources();
//                                 helloworldtext.setText(resources.getString(R.string.language));
//
//                             }
//                         }
//                     })
//                     .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                         @Override
//                         public void onClick(DialogInterface dialogInterface, int i) {
//
//
//
//
//
//                             dialogInterface.dismiss();
//                         }
//                     });
//
//             builder.create().show();
//            }
//        });













        // single item array instance to store
        // which element is selected by user
        // initially it should be set to zero meaning
        // none of the element is selected by default
        final int[] checkedItem = {-1};

        // handle the button to open the alert dialog with
        // the single item selection when clicked
        language_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // AlertDialog builder instance to build the alert dialog
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SamanyaPrarthanaActivity.this);

                // set the custom icon to the alert dialog


                // title of the alert dialog
                alertDialog.setTitle("Choose an language");

                // list of the items to be displayed to
                // the user in the form of list
                // so that user can select the item from
   //             final String[] listItems = new String[]{"English", "Marathi (मराठी )", "Machine Learning"};

                final String[] language ={"English","मराठी "};

             int checkItem;

             if(lang_selected)
             {
                 checkItem=0;

             }
             else {
                 checkItem=1;

             }

                // the function setSingleChoiceItems is the function which builds
                // the alert dialog with the single item selection
                alertDialog.setSingleChoiceItems(language, checkedItem[0], new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        // update the selected item which is selected by the user
                        // so that it should be selected when user opens the dialog next time
                        // and pass the instance to setSingleChoiceItems method
                        checkedItem[0] = i;




                        language_dialog.setText(language[i]);

                             if(language[i].equals("English"))
                             {

                                 initData();
                                 setRecyclerView();
                                 context = LocalHelper.setLocale(SamanyaPrarthanaActivity.this,"en");
                                 resources=context.getResources();
                                 helloworldtext.setText(resources.getString(R.string.language));

                             }




                        if(language[i].equals("मराठी "))
                             {

                                 initData2();
                                 setRecyclerView2();
                                 context = LocalHelper.setLocale(SamanyaPrarthanaActivity.this,"hi");
                                 resources=context.getResources();
                                 helloworldtext.setText(resources.getString(R.string.language));

                             }



                        // now also update the TextView which previews the selected item
                        helloworldtext.setText("Selected Language is : " + language[i]);

                        // when selected an item the dialog should be closed with the dismiss method
                        dialog.dismiss();
                    }
                });

                // set the negative button if the user
                // is not interested to select or change
                // already selected item
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                // create and build the AlertDialog instance
                // with the AlertDialog builder instance
                AlertDialog customAlertDialog = alertDialog.create();

                // show the alert dialog when the button is clicked
                customAlertDialog.show();
            }
        });


















































        recyclerView = findViewById(R.id.recyclerView);


        initData2();
        setRecyclerView2();


    }

    private void setRecyclerView() {
        VersionAdapter versionAdapter = new VersionAdapter(versionsList);
        recyclerView.setAdapter(versionAdapter);
        recyclerView.setHasFixedSize(true);

    }

    private void initData() {

        versionsList = new ArrayList<>();
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));

    }



    private void setRecyclerView2() {
        VersionAdapter versionAdapter = new VersionAdapter(versionsList);
        recyclerView.setAdapter(versionAdapter);
        recyclerView.setHasFixedSize(true);

    }

    private void initData2() {

        versionsList = new ArrayList<>();
        versionsList.add(new Versions("१. क्रुसाची खूण", " ", " ", "हे परमेश्वरा, पवित्र क्रूसाच्या या खूणेने, आमच्या शत्रूपासून आम्हाला सोडव, पिता आणि पुत्र आणि पवित्र आत्मा यांच्या नावे, आमेन .\n" +
                                                                                                "क्रूसाची खूण (संक्षिप्त)\n" +
                                                                                                "पिता आणि पुत्र आणि पवित्र आत्मा यांच्या नावे आमेन."));

        versionsList.add(new Versions("२. प्रभूची प्रार्थना", " ", " ", "हे आमच्या स्वर्गीय बापा, तुझे नांव पवित्र मानले जावो, तुझे राज्य येवो. जसे स्वर्गात तसे पृथ्वीवरही तुझ्या इच्छेनुसार होवो,\n"+
                                                                                                "आमची रोजची भाकर रोजआम्हाला दे. जसे आम्ही आमच्या अपराध करणाऱ्यांना क्षमा करतो तसे \n"+
                                                                                                "तू आमच्या अपराधांची क्षमा कर आणि आम्हाला मोहात पडू देऊ नकोस तरवाईटापासून आम्हाला. सोडव. आमेन."));

        versionsList.add(new Versions("३. नमो मरीये", " ", " ", "नमो हे कृपापूर्ण मरीये, प्रभु तुझ्याठायी आहे.\n" +
                                                                                               "स्त्रियांमध्ये तू धन्य आणि धन्य तुझ्या उदराचे फळ येशू. पवित्र मरीये देवाच्या माते आम्हा पाप्यांसाठी आता आणि आमच्या मरणाच्या वेळी विनंती कर, आमेन ."));

        versionsList.add(new Versions("४. त्रैक्याची स्तुती", " ", " ", "पिता आणि पुत्र आणि पवित्र आत्मा यांचा गौरव असो, जसा प्रारंभी होता तसा आता आहे, आणि सदा सर्वकाळ असेल. आमेन."));

        versionsList.add(new Versions("५. प्रेषितांचा श्रद्धास्वीकार", " ", " ", "स्वर्ग आणि पृथ्वी यांचा उत्पन्नकर्ता, सर्वशक्तिमान परमेश्वर पिता यावर मी श्रद्धा ठेवतो (ते). आणि त्याचा एकुलता एक पुत्र आमचा प्रभु येशू खिस्तयावरही श्रद्धा ठेवतो (ते).\n"+
                                                                                                        "पवित्र आत्म्याच्या योगे तो गर्भरूप झाला; कुवारी मरियेपासून जन्मला; पोन्ती पिलाताच्या आमदानीत त्याने दुःख भोगले; त्यालाक्रूसावर चढविले; तो मरण पावला आणि त्याला पुरले;\n"+
                                                                                                        " तो अधोलोकात उतरला; तिसऱ्या दिवशी मृतातून उठला, स्वर्गात चढला आणि सर्वशक्तिमानदेवपित्याच्या उजवीकडे बसलेला आहे. तेथून तो जीवंताचा व मृतांचा न्याय करण्यास\n"+
                                                                                                            "पुन्हा येणार आहे. पवित्र आत्मा, पवित्र कॅथोलिक महामंडळ, संताचा एकोपा, पापांची क्षमा, देहाचे पुनरुत्थान आणि सार्वकालीक जीवन यांवर मी श्रद्धा ठेवतो (ते). आमेन ."));

        versionsList.add(new Versions("६. त्रिसंध्या जप", " ", " ", "अ. देवदूताचा संदेश (सर्व साघारण दिवशी)\n" +
                "देवदूताने मरीयेला संदेश दिला, आणि ती पवित्र आत्म्याच्या योगे गर्भवती झाली.\n" +
                "नमो हे कृपापूर्ण मरीये ..........\n" +
                "पाहा मी प्रभूची सेविका आहे,\n" +
                "तुझ्या शब्दाप्रमाणे माझ्याठायी होवो.\n" +
                "नमो हे कृपापूर्ण मरीये.......\n" +
                "आणि देवशब्द मनुष्य झाला.\n" +
                "व आमच्यात येऊन राहीला.\n" +
                "नमो हे कृपापूर्ण मरीये...........\n" +
                "ख्रिस्ताने दिलेल्या वचनास आम्ही पात्र व्हावे.\n" +
                "म्हणून हे पवित्र देवमाते आम्हासाठी विनंती कर.\n" +
                "आपण प्रार्थना करु : हे प्रभो, आमची मनें तुझ्या कृपेने अशी संपन्न कर की, ख्रिस्त तुझा पुत्र, ज्याच्या देहधारणाचा संदेश दुताने आम्हाला दिला, त्याच्या\n" +
                "दुःखसहनाच्या व क्रूसाच्या योगे, आम्हाला पुनरुत्थानाचे वैभव मिळावे असे आम्ही त्याच आमच्या प्रभू ख्रिस्ताद्वारे विनवितो, आमेन.\n" +
                "पिता, आणि पुत्र आणि पवित्र आत्मा यांचा गौरव असो, जसा प्रारंभी होता तसा आता आहे, आणि सदा सर्वकाळ असेल आमेन. (३)\n" +
                "\n"+
                "ब. पवित्र आठवड्यातील त्रिसंघ्या जप\n" +
                "(पवित्र बुधवार सायंकाळपासून पवित्र शनिवार सायंकाळ पर्यंत)\n" +
                "ख्रिस्त आम्हासाठी मरणापर्यंत आज्ञाधारक झाला. होय तो क्रूसावरील मरणापर्यंत आज्ञाधारक झाला. म्हणून देवाने त्याला अत्यच्च केले. आणि सर्वनामापेक्षा जे श्रेष्ठ नांव ते त्याला दिले. (फिलिपि. २:७-९)\n" +
                "हे आमच्या स्वर्गीय बापा.\n" +
                "हे परमेश्वर आमचा प्रभु येशू ख्रिस्त स्वत:ला शत्रुकडे सोपवून क्रूसावरील मरणाचे दु:ख सोसुन तारलेल्या आमच्या या कुटुंबावर तुझा आशीर्वाद दे. असे\n" +
                "आम्ही तुझ्या बरोबर सदा राज्य करणाऱ्या आमच्या प्रभू येशू ख्रिस्ताद्वारे मागतो. आमेन.\n" +
                "क. पुनरुत्थान काळातील त्रिसंध्या जप\n" +
                "शुनर्त्वानच्या रविवारपासून पवित्र तरैक्याच्या रविवारपर्यंत)\n" +
                "हे स्वर्गगणी उल्हासित हो, आलेलूया\n" +
                "कारण येशूला धारण करण्यासाठी तू पात्र झालीस, आलेलूया\n" +
                "तो आपल्या वचनानुसार पुनरुत्थित झाला, आलेलूया\n" +
                "आम्हासाठी परमेश्\u200Dवरजवळ विनंती कर, आलेलूया\n" +
                "आनंदित हो, उल्हासित हो, हे कुमारी मरिये, आलेलूया\n" +
                "कारण प्रभु खरेखर जीवंत झाला आहे, आलेलूया\n" +
                "आपण प्रार्थना करू: हे परमेश्वरा, तुझा पुत्र आमचा प्रभु येशू ख्रिस्त याच्या पुनरूत्थानाने तु जगाला आनंद देण्याची कृपा केलीस. त्याची माता. कुमारीमरिया, हिच्या  विनंतीमुळे आम्हांस शाश्\u200Dवत जीवनाचा आनंद मिळावा, असे आम्ही त्याच आमच्या प्रभु ख्रिस्ताद्वारे विनवितो. आमेन.\n" +
                "पिता आणि पूत्र आणि पवित्र आत्मा यांचा गौरव असो. जसा प्रारंभी होता तसा आता आहे, आणि सदा सर्वकाळ असेल. आमेन. (३)"));


        versionsList.add(new Versions("७. नमस्कार हे स्वर्गरणी", " ", " ", "पनमस्कार, हे स्वर्गीय राणी/ दयाळू माते! तू आमचे जीवन/ आमचे माधुर्य/ आणि आमची आशा/ तुला नमस्कार असो./ आम्ही निर्वासित झालेली/ एवेची\n" +
                                                                                                     "मुले/ तुझा धावा करतो./ अश्रुंच्या या दरीत/ शोक करीत/ व रडत आम्ही/ आमचा विश्\u200Dवास/ तुला अर्पण करतो./ म्हणून हे आमच्या कैवारिणी/ आपलीदयामय\n" +
                                                                                                     "नजर/ आम्हाकडे लाव./ आमच्या या निर्वासनानंतर / तुझ्या उदरचे/ सुगंधित फळ, येशू/ याचे दर्शन आम्हाला घडवून दे/ हे दयाळू/ हे ममताळू/ हे मधुर\n" +
                                                                                                    "कुमारी मरीये/ आमेन."));

        versionsList.add(new Versions("८. हे मायाळू कुमारी मरिये", " ", " ", "हे मायाळू कुमारी मरिये, आपल्या संरक्षणासाठी कोणी तुझ्याकडे धाव घेतो, तुझे सहाय्य मागतो, तुझ्या त्याच्याकडे तू पाठ फिरवितेस नाही. याची तूआठवण कर.\n" +
                                                                                                         "हे सर्वश्रेष्ठ कुमारी व माते, या श्रद्धेने प्रेरीत होऊन, मी पापी तुझ्याकडे धाव घेतो (ते). तुझ्या जवळ येतो (ते), हे देवशब्दाचे माते, माझी विनंती नाकारुनकोस, तर प्रसन्न होऊन ती मान्य कर. आमेन."));

        versionsList.add(new Versions("९. कबूल", " ", " ", "सर्वशक्तिमान परमेश्वर, सदा कुमारी मरिया, पवित्र मिखाएल देवदूत, पवित्र योहान बापितस्ता, पवित्र पेत्र व पौल, आमचा पिता प्रेषित थोमा सर्व पवित्रजण यांजवळ व तुम्हा गुरुस्वामीजवळ मी पापी कबुल करतो (ते) की, कल्पनांनी, कामांनी व शब्दांनी फार पापे केली आहेत.\n" +
                                                                                            "हा माझा अपराध, हा माझाफार मोठा अपराध आहे. म्हणून सदा कुमारी मरिया, पवित्र मिखाएल देवदूत, पवित्र योहान बाणिस्ता, पवित्र पेत्र व पौल, आमचा पिता प्रेषीत थामा सर्वपवित्र जण यांजवळ व तुम्हा गुरुस्वामीजवळ मी मागतो (ते) की देवापाशी 'मजकरीता विनंती करा. आमेन\n" +
                                                                                             "( कबुलीसंक्षिप्त )\n" +
                                                                                              "मी, दीन, पापी (मनुष्य/स्त्री) सर्वशक्तिमान देवाजवळ व तुम्ह गुरुस्वामीजवळ पापे कबुल करतो (ते) की, कल्पनांने कामाने व शब्दांनी फार पापे केले (ली)\n" +
                                                                                              "कि हा माझा अपराध, हा माझा फार मोठा अपराध आहे\n" +
                                                                                              "(केलेली पापे स्पष्ट सांगावी)\n" +
                                                                                               "या आणि आयुष्यातील केलेल्या सर्व पापांबद्दल मला मनापासून दु:ख होते. आता देवाच्या कृपेने माझे आचरण सुधारण्याचा दृढ निश्\u200Dचय करतो (ते) वनग्रतेने\n" +
                                                                                                "पापांची क्षमा मागतो (ते). आमेन ."));

        versionsList.add(new Versions("१०. पश्यतापाची  प्रार्थना", " ", " ", "हे माझ्या परमेश्वरा, तू असीम चागंला व परिपूर्ण आहेस म्हणून इतर सर्व वस्तूपेक्षा तूच माझ्या प्रेमाचा योग्य आहेस. पाप करुन तुझा अपमानकेल्याबद्दल मी\n" +
                                                                                                       "मनापासून पश्चाताप करतो (ते) व पापांचा द्वेष करतो (ते). माझ्या पापामुळे मी माझा आत्मा अशुद्ध केला आणि स्वर्गाचे सुख गमावून नरकाच्या शिक्षेसपात्र झालो (ली). यामुळे मला मनापासून दु:ख होते.\n"+
                                                                                                      " मी तुझ्यावर प्रेम करतो (ते) आणि तुझ्या कृपेमुळे मी पापमय प्रंसगापासून दुर राहीन. यापुढे मीकधीही पाप करणार नाही, असे वचन देतो (ते) आमेन .\n"+
                                                                                                        "( संक्षिप्त )\n" +
                                                                                                          "हे माझ्या परमेश्वरा, तुझा अपमान केल्यामुळे मला मनापासून दु:ख होते. तू फार चांगला आहेस. म्हणून मी तुझ्यावर सर्वात अधिक प्रेम करतो (ते) यापुढेमी कधीही पाप करणार नाही."));

        versionsList.add(new Versions("११. परमेश्वराच्या दहा आज्ञा", " ", " ", "१. एकाच खऱ्या परमेश्\u200Dवराची आराधना करा आणि म्हणून मूर्तिपूजा करू नका.\n" +
                                                                                                          "२. परमेश्\u200Dवराचे नाव विनाकाराण घेऊ नका.\n" +
                                                                                                          "३. रविवार पवित्रपणे पाळा.\n" +
                                                                                                          "४. आईवडीलांचा सन्मान कग.\n" +
                                                                                                          "५. हत्या करू नका.\n" +
                                                                                                          "६. व्यभिचार करू नका.\n" +
                                                                                                           "७. चोरी करू नका.\n" +
                                                                                                          "८. खोटी साक्ष देऊ नका.\n" +
                                                                                                           "९. परस्त्रीची / परपुरुषाची इच्छा धरू नका.\n" +
                                                                                                           "१०. परधनाचा लोभ धरू नका"));

        versionsList.add(new Versions("१२. महामंडळाच्या आज्ञा", " ", " ",   "१. पवित्र बलिदान भक्तीने अपूर्ण सर्व रविवार नेमलेल्या सणाचे दिवस पवित्रपणे पाळा,\n" +
                                                                                                        "२. वर्षातून निदान एकदातरी प्रायश्चित संस्कार घ्या आणि पास्का काळाच्या आसपास पवित्र खिस्तशरीर संस्कार घ्या.\n" +
                                                                                                        "३. नेमलेल्या दिवशी उपवास करा आणि मांसाहार करू नका\n" +
                                                                                                        "४. मना केलेल्या पिढीतील नातेवाईकाशी किंवा अपुऱ्या वयात लग्न करू नका आणि मना केलेल्या काळात लग्न समारंभ करू नका.\n"+
                                                                                                        "५. देवळाला दशांश दया."));

        versionsList.add(new Versions("१३. मनुष्याचे अंत (वार)", " ", " ", "१. मृत्यू २ न्याय (विधी) ३. स्वर्ग ४. नग्क"));


        versionsList.add(new Versions("१४. श्रद्धेची प्रार्थना", " ", " ", "हे माझ्या परमेश्वरा, तू मुर्तिमंत सत्य आहेस, म्हणून तुझ्यावर मी श्रद्धा ठेवतो (ते). पवित्र काथोलिक महामंडळ ज्या-ज्या गोष्टीवर विश्\u200Dवास करतातआणि शिकवितात त्या सर्वांवार मी श्रद्धा ठेवतो (ते). कारण सदैव खरा असलेला तूच प्रभु, हे प्रगट केले आहे. माझी श्रद्धा दृढ कर. (\n" +
                                                                                                    "(संक्षिप्त)\n" +
                                                                                                     "हे माझ्या परमेश्वरा, तू मुर्तिमंत सत्य आहेस, म्हणून मी तुझ्यावर श्रद्धा ठेवतो (ते). माझी श्रद्धा दृढ कर."));

        versionsList.add(new Versions("१५. आशेची प्रार्थना", " ", " ", "हे माझ्या परमेश्वर, दयासागरा तू सर्वशक्तिमान व सदैव आपलें वचन पाळणाग आहेस आणि तुझ्यावर आशा ठेवणारे कोणी लज्जित होणार नाहीम्हणून मी तुझ्यावर आशा ठेवतो (ते). माझी आशा बळकट कर."));

        versionsList.add(new Versions("१६. प्रेमाची प्रार्थना", " ", " ", "हे माझ्या परमेश्\u200Dवर, तू असीम चांगला व परिपूर्ण आहेस म्हणून मी तुझ्यावर सर्वात अधिक प्रेम करतो (ते). तुझ्यावर अधिकाधिक प्रेम करण्यास मला शिकव.\n" +
                                                                                                   "ख्रिस्तसभेचे आचार्य म्हणतात.\n" +
                                                                                                   "असा कोणताही मानव समूह नाही की जो जगाचा निर्माणकर्ता परमेश्वरास क्रुसरूपी येशूच्या नांवावर प्रार्थना आणि आभार स्तुती अर्पित नाही."));

    }



}