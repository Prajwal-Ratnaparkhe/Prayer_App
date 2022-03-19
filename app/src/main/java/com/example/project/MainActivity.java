
package com.example.project;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.cardview.widget.CardView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

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
                        Intent intent = new Intent(MainActivity.this,PrarthanaActivity.class);
                        startActivity(intent);
                    }

                    else  if(finalI==1)
                    {
                        Intent intent = new Intent(MainActivity.this,MissaActivity.class);
                        startActivity(intent);
                    }


                    else  if(finalI==2)
                    {
                        Intent intent = new Intent(MainActivity.this,Bhajan.class);
                        startActivity(intent);
                    }

                    else  if(finalI==3)
                    {
                        Intent intent = new Intent(MainActivity.this,Novena.class);
                        startActivity(intent);
                    }

                    else  if(finalI==4)
                    {
                        Intent intent = new Intent(MainActivity.this,MalaV.class);
                        startActivity(intent);
                    }

                    else  if(finalI==5)
                    {
                        Intent intent = new Intent(MainActivity.this,DharmaV.class);
                        startActivity(intent);
                    }

                    else  if(finalI==6)
                    {
                        Intent intent = new Intent(MainActivity.this,Vachan.class);
                        startActivity(intent);
                    }

                    else  if(finalI==7)
                    {
                        Intent intent = new Intent(MainActivity.this,Nivedan.class);
                        startActivity(intent);
                    }

                    else  if(finalI==8)
                    {
                        Intent intent = new Intent(MainActivity.this,Khahani.class);
                        startActivity(intent);
                    }

                    else  if(finalI==9)
                    {
                        Intent intent = new Intent(MainActivity.this,SthiPrar.class);
                        startActivity(intent);
                    }

                }
            });
        }
    }
}