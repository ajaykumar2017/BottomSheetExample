package com.tecent.bottomsheetexample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ExampleBottomSheetDialog extends BottomSheetDialogFragment {

    private BottomSheetListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.botttom_sheet, container, false);
        Button button1=view.findViewById(R.id.button1);
        Button button2=view.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onButtonClicked("Button 1 Clicked");
                dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onButtonClicked("Button 2 clicked");
                dismiss();
            }
        });
        return view;
    }

    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener= (BottomSheetListener) context;
        }
        catch (ClassCastException error){
            throw new ClassCastException(context.toString()+"must implement BottomSheetListener");
        }
    }
}
