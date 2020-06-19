package com.zhihao.category;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 左侧菜单ListView的适配器
 */
public class LeftAdapter extends BaseAdapter {

	private Context context;
	private int selectItem = 0;
	private List<String> list;

	LeftAdapter(Context context, List<String> list) {
		this.list = list;
		this.context = context;
	}

	public int getSelectItem() {
		return selectItem;
	}

	void setSelectItem(int selectItem) {
		this.selectItem = selectItem;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_menu, null);
			convertView.setTag(new ViewHolder(convertView));
		}
		initializeViews(position, (ViewHolder) convertView.getTag());
		return convertView;
	}

	private void initializeViews(int position, ViewHolder holder) {
		if (position == selectItem) {
			holder.tv_name.setBackgroundColor(Color.WHITE);
			holder.tv_name.setTextColor(context.getResources().getColor(R.color.green));
		} else {
			holder.tv_name.setBackgroundColor(context.getResources().getColor(R.color.background));
			holder.tv_name.setTextColor(context.getResources().getColor(R.color.black));
		}
		holder.tv_name.setText(list.get(position));
	}

	static class ViewHolder {
		private TextView tv_name;

		ViewHolder(View view) {
			tv_name = view.findViewById(R.id.item_name);
		}
	}
}
