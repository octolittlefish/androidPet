package com.rdc.goospet.model;

import com.rdc.goospet.R;
import com.rdc.goospet.entity.PetInfo;
import com.rdc.goospet.model.minterface.MainMInterface;
import com.rdc.goospet.utils.AppConstants;

import java.util.ArrayList;

/**
 * Created by Goo on 2016-9-18.
 */
public class MainModel implements MainMInterface {
    @Override
    public ArrayList<PetInfo> getPetData() {
        ArrayList<PetInfo> data = new ArrayList<>();
        data.add(new PetInfo(AppConstants.PET_OWL, "模型一", "简介", R.drawable.pic_owl_main, false));
        data.add(new PetInfo(AppConstants.PET_PIG, "模型二", "简介", R.drawable.pic_pig_main, false));
        data.add(new PetInfo(AppConstants.PET_COW, "模型三", "简介", R.drawable.pic_cow_main, false));
        data.add(new PetInfo(AppConstants.PET_BIRD, "模型四", "简介", R.drawable.pic_bird_main, false));
        return data;
    }
}
