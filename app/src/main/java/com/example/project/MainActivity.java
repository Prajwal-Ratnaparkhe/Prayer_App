
package com.example.project;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.cardview.widget.CardView;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.GridLayout;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private Switch btnToggleDark;







    GridLayout mainGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGridLayout = (GridLayout) findViewById(R.id.mainGridLayout);

        setSingleEvent(mainGridLayout);
    }

    private void setSingleEvent(GridLayout mainGridLayout) {

        for(int i=0;i<mainGridLayout.getChildCount();i++){
            CardView cardView = (CardView)mainGridLayout.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0)
                    {
                        Intent intent = new Intent(MainActivity.this, SamanyaPrarthanaActivity.class);
                        startActivity(intent);
                    }

                    else  if(finalI==1)
                    {
                        Intent intent = new Intent(MainActivity.this, PaviBalidan.class);
                        startActivity(intent);
                    }


                    else  if(finalI==2)
                    {
                        Intent intent = new Intent(MainActivity.this, PaviBible.class);
                        startActivity(intent);
                    }

                    else  if(finalI==3)
                    {
                        Intent intent = new Intent(MainActivity.this,PaviBalidanGit.class);
                        startActivity(intent);
                    }

                    else  if(finalI==4)
                    {
                        Intent intent = new Intent(MainActivity.this, RojriMala.class);
                        startActivity(intent);
                    }

                    else  if(finalI==5)
                    {
                        Intent intent = new Intent(MainActivity.this, SamahuhikPrar.class);
                        startActivity(intent);
                    }

                    else  if(finalI==6)
                    {
                        Intent intent = new Intent(MainActivity.this,PrarsanganusarPrar.class);
                        startActivity(intent);
                    }

                    else  if(finalI==7)
                    {
                        Intent intent = new Intent(MainActivity.this, Novena.class);
                        startActivity(intent);
                    }

                    else  if(finalI==8)
                    {
                        Intent intent = new Intent(MainActivity.this, SakalPrar.class);
                        startActivity(intent);
                    }

                    else  if(finalI==9)
                    {
                        Intent intent = new Intent(MainActivity.this, RatriPrar.class);
                        startActivity(intent);
                    }

                    else  if(finalI==10)
                    {
                        Intent intent = new Intent(MainActivity.this, MrutasathiPrar.class);
                        startActivity(intent);
                    }

                    else  if(finalI==11)
                    {
                        Intent intent = new Intent(MainActivity.this, KrusachaVatechi.class);
                        startActivity(intent);
                    }

                    else  if(finalI==12)
                    {
                        Intent intent = new Intent(MainActivity.this, DharmaShik.class);
                        startActivity(intent);
                    }

                    else  if(finalI==13)
                    {
                        Intent intent = new Intent(MainActivity.this,KatholicSindh.class);
                        startActivity(intent);
                    }

                    else  if(finalI==14)
                    {
                        Intent intent = new Intent(MainActivity.this,GitBhajan.class);
                        startActivity(intent);
                    }



                }
            });
        }
    }





    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You Want to Exit")
        .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item, menu);














//        MenuItem itemswitch = menu.findItem(R.id.switch_action_bar);
//        itemswitch.setActionView(R.layout.use_switch);
//        final Switch sw = (Switch) menu.findItem(R.id.switch_action_bar).getActionView().findViewById(R.id.switch2);
//
//        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    Toast.makeText(MainActivity.this, "Switch is on", Toast.LENGTH_SHORT).show();
//                }
//
//                else {
//                    Toast.makeText(MainActivity.this, "Switch is off", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//
//        MenuItem menuItem = menu.findItem(R.id.search);
//        SearchView searchView=(SearchView) menuItem.getActionView();
//        searchView.setQueryHint("Type here to search");
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//
//
//
//                return false;
//            }
//        });









        return true;
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int item_id= item.getItemId();

        if(item_id==R.id.share)
        {

            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sub = "https://play.google.com/store/apps/details?id=my.example.javatpoint";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
            startActivity(Intent.createChooser(myIntent, "Share Using"));
        }

       else if(item_id==R.id.rate)
        {
            Toast.makeText(this," rate",Toast.LENGTH_LONG).show();

        }


        else if(item_id==R.id.translate)
        {
            Toast.makeText(MainActivity.this,"Change Your language in next tab",Toast.LENGTH_LONG).show();


        }


        else if(item_id==R.id.exit)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do You Want to Exit")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            MainActivity.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }




        return true;
    }
}