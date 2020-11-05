package com.example.fishmob;

import android.widget.Button;

// this is the java class, in which uses to customize and manage the contents in the fishitemcardviewwer.java
//And its responding layout class fishitemcardviewer.xml.
class fishitemcardviewer {
    private  int mImageResource;
    private  String nameOfFish;
    private String weightOfFish;
    private String costOfFish;
     public fishitemcardviewer(int imageResource, String fishName, String fishWeight, String fishCost){

         this.mImageResource=imageResource;
         this.nameOfFish=fishName;
         this.weightOfFish=fishWeight;
         this.costOfFish=fishCost;

     }

     public int getImageResource(){
         return mImageResource;
     }
     public String getNameOfFish(){
         return nameOfFish;
     }

     public  String getWeightOfFish(){
         return  weightOfFish;
     }
     public  String getCostOfFish(){
         return costOfFish;
     }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public void setNameOfFish(String nameOfFish) {
        this.nameOfFish = nameOfFish;
    }

    public void setWeightOfFish(String weightOfFish) {
        this.weightOfFish = weightOfFish;
    }

    public void setCostOfFish(String costOfFish) {
        this.costOfFish = costOfFish;
    }
}
