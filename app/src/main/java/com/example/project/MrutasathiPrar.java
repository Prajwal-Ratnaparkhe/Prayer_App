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

public class MrutasathiPrar extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Versions> versionsList;

    TextView language_dialog,helloworldtext;
    boolean lang_selected=true;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mruta_p);

        getSupportActionBar().setTitle("मृतांसाठी प्रार्थना ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        language_dialog = (TextView)findViewById(R.id.dialog_language);
        helloworldtext = (TextView)findViewById(R.id.textview);







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
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MrutasathiPrar.this);

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
                            context = LocalHelper.setLocale(MrutasathiPrar.this,"en");
                            resources=context.getResources();
                            helloworldtext.setText(resources.getString(R.string.language));

                        }




                        if(language[i].equals("मराठी "))
                        {

                            initData2();
                            setRecyclerView2();
                            context = LocalHelper.setLocale(MrutasathiPrar.this,"hi");
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
        versionsList.add(new Versions("Lorem Ipsum", " ", " ", " test"));

    }



    private void setRecyclerView2() {
        VersionAdapter versionAdapter = new VersionAdapter(versionsList);
        recyclerView.setAdapter(versionAdapter);
        recyclerView.setHasFixedSize(true);

    }

    private void initData2() {

        versionsList = new ArrayList<>();
        versionsList.add(new Versions("मृतांसाठी प्रार्थना", " ", " ", "(सदर एकट्याने म्हणावयाची असते तेव्हा कंसातील (-) शब्द गाळावा)\n" +
                "सर्व :- आपल्या प्रभू येशू ख्रिस्ताचा पिता, दयासागर, परमेश्वर , यांचा गौरव असो.\n" +
                "प्रमुख : (बंधुभगिनींनो, आपला बंधु/ आपली भगिनी ......... याच्या / हिच्यासाठी प्रार्थना करण्याकरिता आपण येथे जमलो आहोत. मृत्यूमुळे माणसाच्या जीवनाचा शेवट होत नाही, तर त्यात फक्त बदल होतो. मृत्यूनंतर अनंतकाळच्या शाश्वत  जीवनाला सुरूवात होते या ख्रिस्ती निष्ठेने आपण या प्रार्थनेत सहभागी होऊ या)\n" +
                "प्रमुख: हे दयावंत परमेश्वरा, आमचा बंधु/आमची भगिनी....याला/हिला तू या जीवनातून स्वत:कडे बोलावले आहेस. तुझा पुत्र ख्रिस्त सर्वप्रथम मरणातुन उठला. आमच्याया बंधुला/भगिनीला आम्ही प्रभुकडे सोपवितो. त्याने त्याचा/तिचा स्वीकार करावा आणि अखेरच्या दिवशी त्याला/तिला पुऱ्हा उठवावे अशी आम्ही आपच्या प्रभु खिस्ताद्वारे करतो.\n" +
                "सर्व :- आमेन.\n" +
                "प्रमुख : प्रभो, याला/हिला चिरंतन शांती दे.\n" +
                "सर्व :- आणि अंनत तेजाने ह्याला/हिला प्रकाशित कर. \n" +
                "प्रमुख : हे आमच्या स्वर्गीय..........\n" +
                "प्रमुख : प्रभु म्हणाला होता, पुनरूत्यान व जीवन मी आहे. माझ्यावर श्रद्धा ठेवणारा जरी मरण पावला तरी तो जगेल, त्याला सार्वकालिक मृत्यूचा अनुभव येणार नाही. प्रभो, तुझा मित्र लाजरस जेव्हा मरण पावला तेव्हा तू रडलास. आमच्या दुःखात तू आमचे सांत्वन कर, अशी आम्ही श्रद्धेने  प्रार्थना करतो.\n" +
                "सर्व: हे प्रभो, आमची प्रार्थना ऐक आणि आमच्या बंधु/ भगिनी वर दया कर.\n" +
                "प्रमुखः तू मेलेल्यातुन जिवंत केलस. आमच्या बंधूला/भगिनीला सार्वकालिक जीवन दे अशी आम्ही श्र्ेे प्रार्थना करतो.\n" +
                "सर्व: हे प्रभो, आमची प्रार्थना ऐक आणि आमच्या बंधु/ भगिनी वर दया कर.\n" +
                "प्रमुख : परचात्तापी चोराला तू स्वर्गाचे वचन दिलेस. आमच्या बंधुला/ भगिनीला तू स्वर्गाचे सुख दे, अशी आम्ही श्रद्धेनी प्रार्थना करतो.\n" +
                "सर्व: हे प्रभो, आमची प्रार्थना ऐक आणि आमच्या बंधु/ भगिनी वर दया कर.\n" +
                "प्रमुख: आमच्या या बंधुची/भगिनीची पापे स्थान संस्काराद्वारे धुतली आहेत; तारण तेल त्याच्या/तिच्या शरीराला लावले आहे. आपल्या संतगणात तू त्याला/तिला समील करून घे, अशी आम्ही श्रदेने प्रार्थना करतो.\n" +
                "सर्व - हे प्रभो, आमची प्रार्थचा ऐक आणि आमच्या बंधु/ भगिनी वर दया कर.\n" +
                "प्रमुख :- हे प्रभो, तुझ्या इच्छेप्रमाणे वागण्याची आमच्या या बंधुची/भगिनीची इच्छा होती म्हणून त्याच्या/तिच्या कडुन घडलेल्या. अपराधाची त्याला/तिला दयाने क्षमा कर. ख्रिस्तावरील श्रद्धेमुळे तो/ती तुझ्या प्रजेमध्ये सामावला सामावली होती. आता त्याला/तिला प्रेमाने व दयेने तुझ्या संतगणात समाविष्ट कर.\n"+
                "हे पित्या, सांत्वनकर्त्या परमेश्वरा, तुझ्या या लोकांचे त्यांच्या दुःखात सांत्वन कर. तुझा पुत्र येशू ख्रिस्त याने मरणातून पुन्हा उठून आमच्या जीवनाला नवीन दिशा दिली आहे. या जगात असताना आम्ही सर्वांशी शांतीने वागावे, 'एकमेंकांना क्षमा करून तुझ्या क्षमेस पात्र व्हावे. व ख्रिस्ती वविश्वासाने  एकमेकांचे सांत्वन करावे अशी आम्हाला सदबुध्दी दे, सदासर्वदा.\n" +
                "सर्व: आमेन"));

    }



}