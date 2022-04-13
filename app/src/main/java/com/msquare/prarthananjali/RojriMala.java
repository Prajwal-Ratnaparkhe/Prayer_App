package com.msquare.prarthananjali;

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

public class RojriMala extends AppCompatActivity {


    RecyclerView recyclerView;
    List<Versions> versionsList;

    TextView language_dialog,helloworldtext;
    boolean lang_selected=true;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rojrimala);

        getSupportActionBar().setTitle("रोजरी माला विनंती ");
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
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(RojriMala.this);

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
                            context = LocalHelper.setLocale(RojriMala.this,"en");
                            resources=context.getResources();
                            helloworldtext.setText(resources.getString(R.string.language));

                        }




                        if(language[i].equals("मराठी "))
                        {

                            initData2();
                            setRecyclerView2();
                            context = LocalHelper.setLocale(RojriMala.this,"hi");
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
        versionsList.add(new Versions("पवित्र जपमाला", " ", " ", "हे येशू, तु सर्व चांगुलपणाचा उगम आहेस. आम्ही पापी व कृतघ्न असून तुझ्या अनंत दयेवर आशा ठेवून पवित्र माऊलीच्या सन्मानार्थ पवित्र जपमाळेची प्रार्थना\n" +
                "करीत आहोत. ही प्रार्थना मनापासून भक्ती भावे करण्यासाठी आम्हाला आशीर्वाद दे.\n" +
                "प्रेषषितांचा श्रध्दा स्वीकार.... (पृष्ठ क्र. ८)\n" +
                "हे आमच्या स्वर्गाय....(पृष्ठ क्र ७)\n" +
                "हे पवित्र मरिये, देवबापाच्या कन्ये, आम्हामध्ये “विश्वास ” हे. दैवीदान, फलद्रूप होण्यासाठी तुझ्या पुत्राजवळ आम्हासाठी मध्यस्थी कर.\n" +
                "नमो हे कृपापूर्ण मरिये...\n" +
                "हे पवित्र मरिये, देवपुत्राच्या माते, आम्हामध्ये “आशा” ह्या दैवी दानाची वाढ होण्यासाठी तुझ्या पुत्राजवळ आम्हासाठी मध्यस्थी कर.\n" +
                "नमो हे कृपापूर्ण मरिये...\n" +
                "हे पवित्र मरिये, पवित्र आत्म्याच्या अतिप्रिये, आम्हामध्ये “प्रीती” हृया दैवी दानाची वृद्री होण्यासाठी तुझ्या पुत्राजवळ आम्हासाठी मध्यस्थी कर.\n" +
                "नमो हे कृपापूर्ण मरिये....\n" +
                "पिता पुत्र आणि पवित्र आत्मा यांचा गौरव असो. जसा प्रांरभी, होता तसा आता आहे आणि सदासर्वदा. आमेन,\n" +
                "जपमालेच्या प्रत्येक दशकानंतरची प्रार्थना\n" +
                "हे माझ्या येशू, माझ्या अपराधांची क्षमा कर. नरकाच्या अग्नी पासून आमचा बचाव कर, सर्व लोकांस विशेष करून ज्यांनां तुझ्या दयेची अधिक गरज आहे, त्यांना स्वर्गात ने. आमेन.\n" +
                "१) आनंदाची रहस्ये (सोमवारी व शनिवारी)\n" +
                "१) देवदूताने मरीयेला संदेश दिला. (लूक १: २६-१८)\n" +
                "उद्देश : सर्व लोक देवाचे वचन स्वीकारावा\n" +
                "२) मरीयेने एलिसाबेथाची भेट घेतली. (लूक १: ३९-५६)\n" +
                "उद्देश : खिस्ती लोक विश्वात  बळकट व्हावे\n" +
                "३) येशूने गोठयात जन्म घेतला. (लूक २: १-२०)\n" +
                "उद्देश : पापी लोकानी येशूला ओळखावे.\n" +
                "४) मंदिरात बाळ येशूचे समर्पण झाले. (हूक २:२२-३९)\n" +
                "उद्देश : आपले तन- मन -धन शुद्ध राहावे.\n" +
                "५) येशू मंदिरात सापडला. (लूक २४4६-११)\n" +
                "उद्देश : आपले सर्वस्व देवाला अर्पण करावे.\n" +
                "२) प्रकाशाची रहस्ये (गुरुवारी)\n" +
                "१) यार्देन नदीत येशूचा बाप्तिस्मा, (मत्तय ३: १३-१७)\n" +
                "उद्देश : आपण बाप्िस्म्याच्या प्रतिज्ञेपरमाणे जीवन जगावे.\n" +
                "२) काना गावातील लग्न. (योहान २:१-१२)\n" +
                "उद्देश : आपण येशूच्या वचना प्रमाणे काम करावे.\n" +
                "३) स्वर्गराज्याची घोषणा व प्रायश्चित्तासाठी हाक.(मार्क १: १४-१५)\n" +
                "उद्देश : राजकीय नेते देशाच्या प्रगतीसाठी कार्य\n" +
                "४) येशूचे दिव्य रूपांतरण (लूक ९: २८-३६)\n" +
                "उद्देश : प्रार्थनांद्वारे आमचे रूंपातर व्हावे.\n" +
                "५) परम पवित्र प्रसादाची स्थापना (मार्क १४: २२-२५)\n" +
                "उद्देश : आम्ही बांधव एकमेकांना प्रेम करावे.\n" +
                "३) दुःखाची रहस्ये (मंगळवारी व शुक्रवारी)\n" +
                "१) येशूला रक्ताचा  घाम आला. ( लूक २२: ४२-४४)\n" +
                "उद्देश : लोकांच्या मानसिक दु:खात मदत मिळावे.\n" +
                "२) येशूने चाबकाचे फटके सहन केले (मत्तय १७: १५-२६)\n" +
                "उद्देश : आपल्या जिभेच्या दुरुपयोगाने कोणाला ही दुःखवू नये.\n" +
                "३) येशूने काट्याचा मुकुट वाहिला, (मत्तय २७२७-३७)\n" +
                "उद्देश : आपले दु:ख धीरतेने सोसावे,\n" +
                "४) येशूने भारी क्रूस वाहून नेला. (मत्तय २७: ३१)\n" +
                "उद्देश : आपल्या दु:खाचे क्रूस उचलून येशूच्या मागे जावे.\n" +
                "५) येशूने क्रूसावर प्राण अर्पिले. (लूक २३: ३३-४६)\n" +
                "उद्देश : शत्रू लोकांना माफी द्यावी.\n" +
                "४) वैभवाची रहस्ये ( बुधवारी व रविवारी )\n" +
                "१) येशू तिसऱ्या  दिवशी मृतातून उठला (मार्क १६: १-६)\n" +
                "उद्देश : आम्ही अविश्वासाच्या समाधीतून उठले पाहिजे.\n" +
                "२) चाळीस दिवसानंतर येशू स्वर्गात चढला. (मार्क ६: ५-२)\n" +
                "उद्देश : आपली आशा स्वर्गीय गोष्टीवर दृढ ठेवावी.\n" +
                "३) पवित्र आत्मा शिष्यांवर उतरला (प्रेषित कार्य २: (-(२)\n" +
                "उद्देश : आपण पवित्र आत्म्याने परिपूर्ण व्हावेत\n" +
                "४) पवित्र मरीयेला शरीरासह स्वर्गात नेण्यात आले.(प्रकट १२:१-१४)\n" +
                "उद्देश : आम्ही शेजाऱ्यांच्या प्रीतीत वाढावे.\n" +
                "५) पवित्र मरीयेला स्वर्ग-पृथ्वीची राणी करण्यात आले. (मत्तय ५: ३१-१०)\n" +
                "उद्देश : आपण पवित्र भरीये प्रमाणे जीवन जगावे.\n" +
                "ख्रिस्ताने दिलेल्या वचनास आम्ही पात्र व्हावे म्हणून, हे पवित्र देवमाते, आम्हासाठी विनंती कर.\n" +
                "आपण प्रार्थना करु : हे परमेश्वरा, तुझ्या एकुलत्या एक पुत्राने आपले जीवन मरण व पुरूत्यानाने शाश्वत  तारणाची बक्षिसे आम्हास प्राप्त करुन दिली त्याच\n" +
                "खिस्ताद्वारे आम्ही विनंती करितो की, धन्य कुमारी मरिथेच्या पवित्र मालेच्या या रहस्यांचे ध्यान करून त्याचे तात्पर्य आम्ही आचरणांत आणावे व त्याच्या फळाचा\n" +
                "आम्हाला लाभ व्हावा, असे आम्ही आमच्या प्रभु खिस्ताद्वारे मागतो, आमेन.\n" +
                "पवित्र कुमारी मरीयेची विनंतीमाला\n" +
                "हे प्रभो, आम्हावर दया कर. हे प्रभो, आम्हावर दया कर.\n" +
                "हे ख्रिस्ता, आम्हावर दया कर,  हे ख्रिस्ता, आम्हावर दया कर.\n" +
                "हे प्रभो, आम्हावर दया कर. र हे प्रभो, आम्हावर दया कर,\n" +
                "हे ख्रिस्ता, आमच्या ऐक आपची प्रार्थना ऐक. हे ख्रिस्ता, आमच्या तारणाऱ्या, आमची ऐकुन घे।\n" +
                "हे स्वर्गातील पित्या परमेश्वरा,\n" +
                "हे पुत्र परमेश्वरावर , जगाच्या मुक्तिदात्या,\n" +
                "हे पवित्र आत्मा परमेश्वर ।\n" +
                "हे पवित्र त्रित्व एकच परमेश्वर ।\n" +
                "(खाली दिलेल्या प्रत्येक लिटनी प्रार्थनानंतर प्रत्युत्तर आम्हासाठी विनंती कर.),\n" +
                "हे संत मरीयम,\n" +
                "हे परमेश्वराची पवित्र आई,\n" +
                "हे कुमारींच्या पवित्र कुमारी,\n" +
                "हे ख्रिस्ताच्या माते,\n" +
                "हे ईश्वरी कृपेच्या माते,\n" +
                "हे अति दयाळू माते,\n" +
                "हे अतिशुद्ध माते,\n" +
                "हे अतिविरक्त माते,\n" +
                "हे निदोर्ष माते.\n" +
                "हे निष्कलंक माते\n" +
                "हे प्रियंकर माते,\n" +
                "हे प्रशंसनीय माते,\n" +
                "हे आशर्यकारक  माते,\n" +
                "हे उत्पन्न कर्त्याचे माते,\n" +
                "हे तारणाऱ्याच्या माते,\n" +
                "हे अति सामाजिक कुमारी,\n" +
                "हे आदरणीय कुमारी,\n" +
                "हे स्तृतियोग्य कुमारी,\n" +
                "हे शक्तिमती कुपारी,\n" +
                "हे दयाळू कुमारी,\n" +
                "हे विश्वासू कुमारी\n" +
                "हे भीतीचा आरसा\n" +
                "हे ज्ञानाचा आसना\n" +
                "हे  आमच्या आनंदाच्या कारणा,\n" +
                "हे परमार्थ बुद्धीच्या पात्रा,\n" +
                "हे सन्मानाच्या पात्रा,\n" +
                "हे सुभक्तीच्या उत्कृष्ठ पात्रा,\n" +
                "हे रहस्य गुलाबा,\n" +
                "हे दाविदाचा बुरूजा,\n" +
                "हे हस्तिदंती बुरुजा \n" +
                "हे सोनेरी घरा\n" +
                "हे कराराचा कोशा\n" +
                "हे स्वर्गाच्या दरवाजा,\n" +
                "हे सकाळच्या नक्षत्रा\n" +
                "हे रोग्यांच्या आरोग्या,\n" +
                "हे पाप्यांच्या आश्रया,\n" +
                "हे दुखितांचे सांत्वना\n" +
                "हे ख्रिस्तीयांची सहाय्या,\n" +
                "हे देवदु्तांच्या राणी,\n" +
                "हे आदिपितरांच्या राणी,\n" +
                "हे भविष्यवाद्यांच्या राणी,\n" +
                "हे प्रेषितांच्या राणी ,\n" +
                "हे रक्तसाक्ष्यांच्या राणी,\n" +
                "हे वर्तनसाक्ष्यांच्या राणी,\n" +
                "हे कुमारींच्या राणी,\n" +
                "हे सर्व संतांचे राणी.\n" +
                "हे अमलोदभव राणी,\n" +
                "हे स्वर्गारोपित राणी,\n" +
                "हे पवित्र मालेची राणी,\n" +
                "हे शांतीच्या राणी,\n" +
                "किंवा\n" +
                "पवित्र कुमारी मरीयेची स्तुती विनंती\n" +
                "१. प्रभो आम्हांवर दया करा\n" +
                "ख्रिस्ता आम्हांवर दया करा\n" +
                "ख्रिस्ता आमची विनंती घ्या\n" +
                "औ प्रभो आम्हांवर दया करा॥\n" +
                "२.  स्वर्गनिवासी देववापा                     \n" +
                "प्रभो आम्हांवर दया करा।                         \n" +
                "तारणदाता देव-पुत्रा                                     \n" +
                "प्रभो आम्हांवर दया करा।                              \n" +
                " ३.  पावनकारी देवात्मा\n" +
                " प्रभो आम्हांवर दया करा।\n" +
                "त्रित्व पावन ईश्वरा\n" +
                " प्रभो आम्हांवर दया करा।\n" +
                "४. पवित्र मरिय देवमाते           \n" +
                "पवित्र कुमारी प्रभु माते !              \n" +
                "वरदानाची हे माते                      \n" +
                "आम्हांसाठी विनंती करा॥                   \n" +
                " ५. अति विशुद्ध हे माते\n" +
                " आति विरक्ता  हे माते ।\n" +
                "अति निर्दोषी हे माते\n" +
                "आम्हांसाठी विनंती करा॥\n" +
                "६. विनयवती तु कन्या माते  \n" +
                "शक्तिमती तु कन्या माते।  \n" +
                "बुद्धिमती तु कन्या माते    \n" +
                "आम्हांसाठी विनंती कर॥             \n" +
                " ७. ज्ञानाचा हे आसन माते\n" +
                " आनंदाचे कारण माते!\n" +
                " दाविदाचे वंशज माते\n" +
                " आम्हांसाठी विनंती करा॥\n" +
                "८.सन्मानाची पात्र माते            \n" +
                "सद्बुद्धीची पात्र माते!           \n" +
                "सद्भक्तीची पात्र माते         \n" +
                "आम्हांसाठी विनंती करा॥         \n" +
                "९. वाग्दानाची कोशा माते\n" +
                " स्वर्गाचा दरवाजा माते।\n" +
                "आजाऱ्याचे रक्षण माते\n" +
                " आम्हांसाठी विनंती कर ॥\n" +
                "१०. पापीयांचे आश्रय माते     \n" +
                "दुःखीयांचे सौख्य माते।   \n" +
                "ख्रिस्तीयांचे सहाय्य माते     \n" +
                "आम्हांसाठी विनंती करा॥   \n" +
                "  ११. प्रेषितांची राणी माते\n" +
                " आचार्यांची राणी माते।\n" +
                " कुमारिकांची राणी माते\n" +
                " आम्हांसाठी विनंती करा॥\n" +
                "१२. संदेष्ट्यांची राणी माते    \n" +
                "शस्त्रिगाणांची राणी माते!\n" +
                "संतगणांची राणी माते     \n" +
                "आम्हांसाठी विनंती करा।।   \n" +
                " १३. पुरोहितांची. राणी: माते\n" +
                " समर्पितांची राणी. माते ।\n" +
                "कुटुंबियांची राणी -माते\n" +
                "आम्हांसाठी! विनंती. कर ||\n" +
                "\n" +
                "१४. सुरदूतांची राणी माते.           \n" +
                "शांतीची तू राणी माते!     \n" +
                "उद्भव  पाप विहीना माते                \n" +
                "आम्हांसाठी विनंती करा!    \n" +
                "१५. कृपा-प्रपूरित दिव्य माते\n" +
                "स्वर्गारेपितत पूज्य: माते!\n" +
                "भारत इच्छित कन्या माते\n" +
                "आम्हासाठी विनंत्ती करा!\n" +
                "जगाची पापे दूर करणाऱ्या परमेश्वराच्या कोंकरा, आम्हांला क्षमा. कर.\n" +
                "जगाची पापे टूर करणाऱ्या परमेश्वराच्या कोंकरा, आपचे ऐकून घे.\n" +
                "जगाची पापे दूर करणाऱ्या  परमेश्वराच्या कोंकरा, आम्हावर दया कर\n" +
                "खिस्नाने दिलेल्या वचनास आम्ही पात्र व्हावे, म्हणून, हे पवित्र देवमाते, आम्हासाठी बिनंती कर\n" +
                "आपण प्रार्थना करू : हे परमेश्वरा, तुझ्या एकुलत्या एक पुत्राने । आपले जीवन, मरण व पुनरुत्थानाने. शाश्\u200Dवत तारणाची बक्षिसे आम्हास प्राप्त करून दिली. त्याच खिस्ताद्वारे आम्ही विनंती करीत्तो की, धन्य कुमारी मरीयेच्या पवित्र मालेच्या या रहस्यांचे ध्यान करून त्याचे तात्पर्य आम्ही आचरणांत आणावे व त्याच्या फळाचा आम्हाला लाभ व्हावा, असे आम्ही आमच्या प्रभू ख्रिस्ताद्वारे मागतो. आमेन.\n" +
                "नमस्कार, हे स्वर्गीय रागी (पृ. क्र, ११)\n" +
                "हे मायाळ कमारी मरीये (पृ. क्र. ११)"));


       versionsList.add(new Versions("दयेची जपमाला", " ", " ", "मोठ्या मण्यांवर \n" +
                                                                                               "स. : हे सनातन पित्या/ तुझा परमप्रिय पुश आमच्या प्रभू येशू ख्रिस्ताचे/ शरीर व रक्त आत्मा आणि दैवत्व/ आमच्या व जगातील सर्व लोक्रांच्या/पापांचा  भरपाईसाठी/ मी तुला अर्पण अर्पण करीतो (ते) आमेन.\n" +
                                                                                              "लहान मण्यांवर\n" +
                                                                                                "ने.  येशू ख्रिस्ताच्या/ दु:खदायक क्रूस मरणा प्रित्यर्थ \n" +
                                                                                                "सं. : आमच्यावर आणि/साऱ्या जगावर दया कर.\n" +
                                                                                            "(दहा वेळा म्हणांवे,)\n" +
                                                                                             "प्रत्येक दशकानंतर\n" +
                                                                                            "स. : हे पवित्र देवा / हे पवित्र समर्था/ हे पवित्र अनंता, आमच्यावर आणि / साऱ्या जगावर दया कर   (३)"));

    }



}