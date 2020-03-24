package com.mcardinals.tracetogetherph;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sign_up extends AppCompatActivity implements View.OnClickListener {
    Button btnNext;
    EditText txtFname;
    EditText txtMname;
    EditText txtLname;
    EditText txtAge;
    EditText txtEmail;

    Button btnExistMedCond;
    Button btnCurrMedCond;

    String[] MedCondsArr;

    boolean[] currSelMedCondsArr;
    boolean[] existSelMedCondsArr;

    ArrayList<Integer> intCurrMedConds = new ArrayList<>();
    ArrayList<Integer> intExistMedConds = new ArrayList<>();

    List<String> CurrMedConds = new ArrayList<>();
    List<String> ExistMedConds = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //Variables for the required values
        txtFname = (EditText) findViewById(R.id.txtFname);
        txtMname = (EditText) findViewById(R.id.txtMname);
        txtLname = (EditText) findViewById(R.id.txtLname);
        txtAge = (EditText) findViewById(R.id.txtAge);
        txtEmail = (EditText) findViewById(R.id.txtEmail);


        //To check currently selected items
        MedCondsArr = getResources().getStringArray(R.array.medical_cond);
        currSelMedCondsArr = new boolean[MedCondsArr.length];
        existSelMedCondsArr = new boolean[MedCondsArr.length];


        btnExistMedCond = (Button) findViewById(R.id.btnExistingMedCond); //for the button Existing Medical Condition
        btnExistMedCond.setOnClickListener(this);

        btnCurrMedCond = (Button) findViewById(R.id.btnCurrMedCond); //for the button Current Medical Condition
        btnCurrMedCond.setOnClickListener(this);

        btnNext = (Button) findViewById(R.id.btnSubmitSignUpInfo); //for the button NEXT
        btnNext.setOnClickListener(this);

    }

    //on button press listeners
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCurrMedCond:


                AlertDialog.Builder CMDbuilder = new AlertDialog.Builder(sign_up.this);
                CMDbuilder.setTitle("Select Current Medical Conditions");
                CMDbuilder.setMultiChoiceItems(MedCondsArr, currSelMedCondsArr, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        if (isChecked) {
                            if (!intCurrMedConds.contains(i)) {
                                intCurrMedConds.add(i);
                            } else {
                                intCurrMedConds.remove(i);
                            }
                        }
                    }
                });

                CMDbuilder.setCancelable(false);
                CMDbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String item = "";
                        for (int j = 0; j < intCurrMedConds.size(); j++) {
                            item = item + MedCondsArr[intCurrMedConds.get(j)];
                            if (j != intCurrMedConds.size() - 1) {
                                item = item + ",";
                            }
                        }
                        String checked[] = item.split(",");
                        CurrMedConds = Arrays.asList(checked);
                    }
                });
                AlertDialog dialogShow = CMDbuilder.create();
                dialogShow.show();
                break;

            case R.id.btnExistingMedCond:
                AlertDialog.Builder EMDbuilder = new AlertDialog.Builder(sign_up.this);
                EMDbuilder.setTitle("Select Existing Medical Conditions");
                EMDbuilder.setMultiChoiceItems(MedCondsArr, existSelMedCondsArr, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        if (isChecked) {
                            if (!intExistMedConds.contains(i)) {
                                intExistMedConds.add(i);
                            } else {
                                intExistMedConds.remove(i);
                            }
                        }
                    }
                });

                EMDbuilder.setCancelable(false);
                EMDbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String item = "";
                        for (int j = 0; j < intExistMedConds.size(); j++) {
                            item = item + MedCondsArr[intExistMedConds.get(j)];

                            if (j != intCurrMedConds.size() - 1) {
                                item = item + ",";
                            }
                        }
                        String checked[] = item.split(",");
                        ExistMedConds = Arrays.asList(checked);
                    }
                });

                AlertDialog dialogShow2 = EMDbuilder.create();
                dialogShow2.show();
                break;

            case R.id.btnSubmitSignUpInfo:
//                for (int i = 0; i < MedCondsArr.length; i++) {
//                    if (intExistMedConds.get(i) == 1) {
//                        ExistMedConds.add(MedCondsArr[i]);
//                    }
//                    if (intCurrMedConds.get(i) == 1) {
//                        CurrMedConds.add(MedCondsArr[i]);
//                    }
//                }

                for (String str : ExistMedConds) {
                    Log.d("The ExistMedConds are", str + ", ");
                }

                for (String str : CurrMedConds) {
                    Log.d("The CurrMedConds are", str + ", ");
                }

                Intent goToMainActivity = new Intent(sign_up.this, MainActivity.class);
                startActivity(goToMainActivity);
                break;

        }
    }

//    @Override //Still in Beta Version. To be implemented - dialog reuse.
//    public void onPositiveButtonClicked(String[] medCond, ArrayList<String> selectedMedConds) {
//        CurrMedConds.removeAll(CurrMedConds);
//        for (String str:selectedMedConds){
//            CurrMedConds.add(str);
//        }
//        for (String str:CurrMedConds){
//            Log.d("The strings are: ", str);
//        }
//    }
//
//    @Override
//    public void onNegativeButtonClicked() {
//
//    }

}
