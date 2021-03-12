package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

    public class DataModels {

        @SerializedName("data")
        private  Model[] modelArray;

        public Model[] getModelArray() {
            return modelArray;
        }

        public void setModelArray(Model[] modelArray) {
            this.modelArray = modelArray;
        }

        @Override
        public String toString() {
            return "[ data are " + Arrays.toString(modelArray) + "]";
        }
    }

