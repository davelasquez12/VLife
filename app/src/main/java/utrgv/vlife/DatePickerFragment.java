package utrgv.vlife;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment
{
	DatePicker mDatePicker;

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date_picker, null);
		mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_picker);

		return new AlertDialog.Builder(getActivity())
				.setView(v)
				.setTitle("Date Select:")
				.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i)
					{

					}
				})
				.setNegativeButton(android.R.string.cancel, null)
				.create();
	}
}
