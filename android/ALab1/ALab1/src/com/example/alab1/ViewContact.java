package com.example.alab1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;



public class ViewContact extends Activity {
	
	private Contact contact;
	private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_layout);
        intent = getIntent();
        contact = (Contact) intent.getSerializableExtra("object");
        
        setUpView();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void setUpView() {
    	
    	TextView name =(TextView) findViewById(R.id.list_item_text_name);
    	TextView add1 =(TextView) findViewById(R.id.list_item_text_add1);
    	TextView email1 =(TextView) findViewById(R.id.list_item_text_email1);
    	TextView homeNum =(TextView) findViewById(R.id.list_item_text_homeNum);
    	TextView mobileNum =(TextView) findViewById(R.id.list_item_text_mobileNum);
    	TextView workNum =(TextView) findViewById(R.id.list_item_text_workNum);
    	TextView dob =(TextView) findViewById(R.id.list_item_text_dob);
//    	
    	name.setText(contact.getFirstName() + " " + contact.getSurName());
    	add1.setText(contact.getAddress());
    	
    	email1.setText(contact.getEmail());
    	
    	homeNum.setText(contact.getHomeNum());
    	mobileNum.setText(contact.getMobileNum());
    	workNum.setText(contact.getWorkNum());
    	dob.setText(contact.getDob());
    	
    	
    	//Creating a contact object
    	   	
//    	Intent intent = new Intent(this, MainActivity.class);
//    	
//    	intent.putExtra("contact", contact);
//    	
//    	startActivity(intent);
    	
    }
    
    public void backToList(View view) {
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
    
    
    
    
}