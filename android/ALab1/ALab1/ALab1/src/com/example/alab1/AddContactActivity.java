package com.example.alab1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;



public class AddContactActivity extends Activity {
	
	private Contact newContact;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void addContact(View view) {
    	
    	//
    	EditText idFirst = (EditText) findViewById(R.id.add_first_name);
    	EditText idSur = (EditText) findViewById(R.id.add_sur_name);
    	EditText idHome = (EditText) findViewById(R.id.add_home_ph);
    	EditText idMobile = (EditText) findViewById(R.id.add_mobile_ph);
    	EditText idWork = (EditText) findViewById(R.id.add_work_ph);
    	EditText idAddress = (EditText) findViewById(R.id.add_street_address);
    	EditText idEmail = (EditText) findViewById(R.id.add_email_address);
    	EditText idDob = (EditText) findViewById(R.id.add_dob);
    	
    	//
    	String firstName = idFirst.getText().toString();
    	String surName = idSur.getText().toString();
    	String homeNum = idHome.getText().toString();
    	String mobileNum = idMobile.getText().toString();
    	String workNum = idWork.getText().toString();
    	String address = idAddress.getText().toString();
    	String email = idEmail.getText().toString();
    	String dob = idDob.getText().toString();
    	
    	
    	//Creating a contact object
    	newContact = new Contact(firstName, surName, address, email, homeNum, mobileNum, workNum, dob);
    	
    	Intent intent = new Intent(this, MainActivity.class);
    	
    	intent.putExtra("contact", newContact);
    	
    	startActivity(intent);
    	
    }
    
    //Method that is executed when cancel button is pressed
    public void cancelAdd(View view) {
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
    
}