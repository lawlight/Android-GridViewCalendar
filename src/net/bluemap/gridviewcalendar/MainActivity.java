package net.bluemap.gridviewcalendar;

import android.app.Activity;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private GVCalendar gvCalendar;
	private Button btnNext;
	private Button btnPre;
	private TextView tvDate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//load the UI
		gvCalendar = (GVCalendar)findViewById(R.id.gvCalendar);
		gvCalendar.initCalendar();
		btnPre = (Button)findViewById(R.id.btn_pre);
		btnNext = (Button)findViewById(R.id.btn_next);
		tvDate = (TextView)findViewById(R.id.tv_date);
		tvDate.setText(gvCalendar.getTitle());
		
		//listener of buttons
		btnPre.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gvCalendar.PreMonth();
				tvDate.setText(gvCalendar.getTitle());
			}
		});
		btnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gvCalendar.NextMonth();
				tvDate.setText(gvCalendar.getTitle());
			}
		});
		
		//on item click, just a test
		gvCalendar.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				GVCalendarItem item = (GVCalendarItem) parent.getItemAtPosition(position);
				item.setHasPlan(!item.isHasPlan());
				item.setPlanString("todo");
				gvCalendar.refreshCalendar();
			}
		});
	}

}
