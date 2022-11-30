package io.github.awwshoot.betternotesapp.ui.calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalendarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CalendarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Integrate with Google Calendar");
    }

    public LiveData<String> getText() {
        return mText;
    }
}