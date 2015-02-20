package net.bluemap.gridviewcalendar;

import java.util.Calendar;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GVCalendarAdapter extends BaseAdapter {

	List<GVCalendarItem> items;
	Context context;
	public GVCalendarAdapter(Context context, List<GVCalendarItem> items){
		this.context = context;
		this.items = items;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView != null) {
			viewHolder = (ViewHolder) convertView.getTag();
		} else {
			convertView = LayoutInflater.from(context).inflate(R.layout.calendar_item, null);
			convertView.setFocusable(false);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		}

		//fill UI
		viewHolder.dateTextView.setText(items.get(position).getDateString());
		viewHolder.planTextView.setText(items.get(position).getPlanString());
		//default
		viewHolder.markImageView.setVisibility(View.INVISIBLE);
		viewHolder.linearLayout.setBackgroundColor(0xffdddddd);
		viewHolder.dateTextView.setBackgroundDrawable(null);
		
		if(items.get(position).isLastOrNextMonth()){		//color of last or next month
			viewHolder.dateTextView.setTextColor(0xff666666);
			viewHolder.linearLayout.setBackgroundColor(0xffcccccc);
			viewHolder.markImageView.setVisibility(View.INVISIBLE);
			viewHolder.planTextView.setVisibility(View.INVISIBLE);
		}
		else{
			//has plan mark
			if(items.get(position).isHasPlan()){
				viewHolder.markImageView.setVisibility(View.VISIBLE);
			}
			//weekend show gray
			if(items.get(position).getDayOfWeek() == Calendar.SUNDAY
					|| items.get(position).getDayOfWeek() == Calendar.SATURDAY){
				viewHolder.dateTextView.setTextColor(0xffe33125);
				viewHolder.planTextView.setTextColor(0xffe33125);
			}
			//today show write
			if(items.get(position).isToday()){
				viewHolder.dateTextView.setTextColor(0xffffffff);
				viewHolder.dateTextView.setBackgroundResource(R.drawable.calendar_item_selected_bg);
			}
		}
		return convertView;
	}
	
	class ViewHolder{
		public ViewHolder(View view){
			this.linearLayout = (LinearLayout)view.findViewById(R.id.ci_ll_item);
			this.dateTextView = (TextView)view.findViewById(R.id.ci_tv_day);
			this.planTextView = (TextView)view.findViewById(R.id.ci_tv_plan);
			this.markImageView = (ImageView)view.findViewById(R.id.ci_iv_mark);
		}
		LinearLayout linearLayout;
		TextView dateTextView;
		TextView planTextView;
		ImageView markImageView;
	}

}
