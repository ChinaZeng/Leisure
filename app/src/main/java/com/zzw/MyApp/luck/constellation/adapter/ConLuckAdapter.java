package com.zzw.MyApp.luck.constellation.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.zzw.MyApp.R;
import com.zzw.MyApp.base.BaseRecyAdapter;
import com.zzw.MyApp.luck.constellation.model.ConstellationModel;
import com.zzw.MyApp.luck.constellation.presenter.IConLuckPresenter;

import org.angmarch.views.NiceSpinner;

import java.util.List;

/**
 * Created by zzw on 2016/7/4.
 * 描述:
 */
public class ConLuckAdapter extends BaseRecyAdapter<ConstellationModel> {

    private LayoutInflater inflater;
    public List<String> spinnerMenu;
    public int nowSelectIndex = 0;
    private AdapterView.OnItemSelectedListener listener;

    private final static int SPINNER = 8;
    private final static int TODAY = 0;
    private final static int TOMORROW = 1;
    private final static int WEEK = 2;
    private final static int NEXT_WEEK = 3;
    private final static int MONTH = 4;
    private final static int YEAR = 5;

    public ConLuckAdapter(Activity context, List<String> spinnerMenu, AdapterView.OnItemSelectedListener listener) {
        super(context);
        this.spinnerMenu = spinnerMenu;
        this.listener = listener;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0)
            return SPINNER;

        if (mData.get(position - 1) == null)
            return super.getItemViewType(position);

        switch (mData.get(position - 1).getType()) {
            case IConLuckPresenter.ConLuckType.TODAY:
                return TODAY;
            case IConLuckPresenter.ConLuckType.TOMORROW:
                return TOMORROW;
            case IConLuckPresenter.ConLuckType.WEEK:
                return WEEK;
            case IConLuckPresenter.ConLuckType.NEXTWEEK:
                return NEXT_WEEK;
            case IConLuckPresenter.ConLuckType.MONTH:
                return MONTH;
            case IConLuckPresenter.ConLuckType.YEAR:
                return YEAR;
        }
        return super.getItemViewType(position);
    }

    @Override
    public void addItem(ConstellationModel constellationModel) {
        mData.add(constellationModel);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case SPINNER:
                return new SpinnerViewHolder(inflater.inflate(R.layout.layout_spinner, parent, false));
            case TODAY:
            case TOMORROW:
                return new DayViewHolder(inflater.inflate(R.layout.item_conluck_day, parent, false));
            case WEEK:
            case NEXT_WEEK:
                return new WeekViewHolder(inflater.inflate(R.layout.item_conluck_week, parent, false));
            case MONTH:
                return new MonthViewHolder(inflater.inflate(R.layout.item_conluck_month, parent, false));
            case YEAR:
                return new YearViewHolder(inflater.inflate(R.layout.item_conluck_year, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof SpinnerViewHolder) {
            SpinnerViewHolder spinnerViewHolder = (SpinnerViewHolder) holder;
            spinnerViewHolder.spinner.attachDataSource(spinnerMenu);
            spinnerViewHolder.spinner.setSelectedIndex(nowSelectIndex);
            if (listener != null)
                spinnerViewHolder.spinner.setOnItemSelectedListener(listener);
        } else {
            ConstellationModel model = mData.get(position - 1);
            if (holder instanceof DayViewHolder) {
                DayViewHolder dayViewHolder = (DayViewHolder) holder;
                if (getItemViewType(position) == TODAY)
                    dayViewHolder.titleText.setText(R.string.luck_today);
                else if (getItemViewType(position) == TOMORROW)
                    dayViewHolder.titleText.setText(R.string.luck_tomorrow);
                dayViewHolder.compositeText.setText(context.getResources().getString(R.string.composite, model.getAll()));
                dayViewHolder.healthIndexText.setText(context.getResources().getString(R.string.health_index, model.getHealth()));
                dayViewHolder.loveIndexText.setText(context.getResources().getString(R.string.love_index, model.getLove()));
                dayViewHolder.moneyIndexText.setText(context.getResources().getString(R.string.money_index, model.getMoney()));
                dayViewHolder.luckNumberText.setText(context.getResources().getString(R.string.luck_number, model.getNumber()));
                dayViewHolder.workIndexText.setText(context.getResources().getString(R.string.work_index, model.getWork()));
                dayViewHolder.QFriendText.setText(context.getResources().getString(R.string.QFriend, model.getQFriend()));
                dayViewHolder.luckColor.setText(context.getResources().getString(R.string.luck_color, model.getColor()));
                dayViewHolder.summaryText.setText(model.getSummary());
            } else if (holder instanceof WeekViewHolder) {
                WeekViewHolder weekViewHolder = (WeekViewHolder) holder;
                if (getItemViewType(position) == WEEK)
                    weekViewHolder.itemConluckWeekTitle.setText(R.string.luck_week);
                else if (getItemViewType(position) == NEXT_WEEK)
                    weekViewHolder.itemConluckWeekTitle.setText(R.string.luck_next_week);
                weekViewHolder.itemConluckWeekDate.setText(model.getDate().trim());
                weekViewHolder.itemConluckWeekHealth.setText(model.getHealth().trim());
                weekViewHolder.itemConluckWeekJob.setText(model.getJob().trim());
                weekViewHolder.itemConluckWeekLove.setText(model.getLove().trim());
                weekViewHolder.itemConluckWeekMoney.setText(model.getMoney().trim());
                weekViewHolder.itemConluckWeekWork.setText(model.getWork().trim());
            } else if (holder instanceof MonthViewHolder) {
                MonthViewHolder monthViewHolder = (MonthViewHolder) holder;
                monthViewHolder.itemConluckMonthTitle.setText(R.string.luck_month);
                monthViewHolder.itemConluckMonthDate.setText(model.getDate());
                monthViewHolder.itemConluckMonthHealth.setText(context.getResources().getString(R.string.health_, model.getHealth().trim()));
                monthViewHolder.itemConluckMonthLove.setText(context.getResources().getString(R.string.love_, model.getLove().trim()));
                monthViewHolder.itemConluckMonthMoney.setText(context.getResources().getString(R.string.money_, model.getMoney().trim()));
                monthViewHolder.itemConluckMonthWork.setText(context.getResources().getString(R.string.work_, model.getWork().trim()));
                monthViewHolder.itemConluckMonthAll.setText(context.getResources().getString(R.string.all_, model.getAll().trim()));
            } else if (holder instanceof YearViewHolder) {
                YearViewHolder yearViewHolder = (YearViewHolder) holder;
                yearViewHolder.itemConluckYearTitle.setText(R.string.luck_year);
                ConstellationModel.MimaBean mimaBean = model.getMima();
                String info = mimaBean.getInfo();
                yearViewHolder.itemConluckYearDate.setText(context.getString(R.string.year_date_hint, model.getDate(), info));
                yearViewHolder.itemConluckYearFinance.setText(context.getString(R.string.finance_, model.getFinance().get(0)));
                yearViewHolder.itemConluckYearText.setText(context.getString(R.string.text_, mimaBean.getText().get(0)));
                yearViewHolder.itemConluckYearCareer.setText(context.getString(R.string.career_, model.getCareer().get(0)));
                yearViewHolder.itemConluckYearHealth.setText(context.getString(R.string.health_, model.getHealth()));
                yearViewHolder.itemConluckYearLove.setText(context.getString(R.string.love_, model.getLove()));
                yearViewHolder.itemConluckYearLuckyStone.setText(context.getString(R.string.luckyStone_, model.getLuckyStone()));
            }
        }
    }


    public static class SpinnerViewHolder extends RecyclerView.ViewHolder {

        public NiceSpinner spinner;

        public SpinnerViewHolder(View itemView) {
            super(itemView);
            spinner = (NiceSpinner) itemView.findViewById(R.id.nice_spinner);
        }
    }


    public static class DayViewHolder extends RecyclerView.ViewHolder {

        public TextView titleText, compositeText, healthIndexText, loveIndexText,
                moneyIndexText, luckNumberText, workIndexText, QFriendText, luckColor, summaryText;

        public DayViewHolder(View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.item_conluck_day_title);
            compositeText = (TextView) itemView.findViewById(R.id.item_conluck_day_composite);
            healthIndexText = (TextView) itemView.findViewById(R.id.item_conluck_day_health_index);
            loveIndexText = (TextView) itemView.findViewById(R.id.item_conluck_day_love_index);
            moneyIndexText = (TextView) itemView.findViewById(R.id.item_conluck_day_money_index);
            luckNumberText = (TextView) itemView.findViewById(R.id.item_conluck_day_luck_number);
            workIndexText = (TextView) itemView.findViewById(R.id.item_conluck_day_work_index);
            QFriendText = (TextView) itemView.findViewById(R.id.item_conluck_day_QFriend);
            luckColor = (TextView) itemView.findViewById(R.id.item_conluck_day_luck_color);
            summaryText = (TextView) itemView.findViewById(R.id.item_conluck_day_summary);
        }
    }

    public static class WeekViewHolder extends RecyclerView.ViewHolder {

        public TextView itemConluckWeekTitle;
        public TextView itemConluckWeekDate;
        public TextView itemConluckWeekHealth;
        public TextView itemConluckWeekJob;
        public TextView itemConluckWeekLove;
        public TextView itemConluckWeekMoney;
        public TextView itemConluckWeekWork;

        public WeekViewHolder(View view) {
            super(view);
            itemConluckWeekTitle = (TextView) view.findViewById(R.id.item_conluck_week_title);
            itemConluckWeekDate = (TextView) view.findViewById(R.id.item_conluck_week_date);
            itemConluckWeekHealth = (TextView) view.findViewById(R.id.item_conluck_week_health);
            itemConluckWeekJob = (TextView) view.findViewById(R.id.item_conluck_week_job);
            itemConluckWeekLove = (TextView) view.findViewById(R.id.item_conluck_week_love);
            itemConluckWeekMoney = (TextView) view.findViewById(R.id.item_conluck_week_money);
            itemConluckWeekWork = (TextView) view.findViewById(R.id.item_conluck_week_work);
        }
    }


    public static class MonthViewHolder extends RecyclerView.ViewHolder {

        public TextView itemConluckMonthTitle;
        public TextView itemConluckMonthDate;
        public TextView itemConluckMonthHealth;
        public TextView itemConluckMonthAll;
        public TextView itemConluckMonthLove;
        public TextView itemConluckMonthMoney;
        public TextView itemConluckMonthWork;

        public MonthViewHolder(View view) {
            super(view);
            itemConluckMonthTitle = (TextView) view.findViewById(R.id.item_conluck_month_title);
            itemConluckMonthDate = (TextView) view.findViewById(R.id.item_conluck_month_date);
            itemConluckMonthHealth = (TextView) view.findViewById(R.id.item_conluck_month_health);
            itemConluckMonthAll = (TextView) view.findViewById(R.id.item_conluck_month_all);
            itemConluckMonthLove = (TextView) view.findViewById(R.id.item_conluck_month_love);
            itemConluckMonthMoney = (TextView) view.findViewById(R.id.item_conluck_month_money);
            itemConluckMonthWork = (TextView) view.findViewById(R.id.item_conluck_month_work);
        }
    }

    public static class YearViewHolder extends RecyclerView.ViewHolder {

        public TextView itemConluckYearTitle;
        public TextView itemConluckYearDate;
        public TextView itemConluckYearLuckyStone;
        public TextView itemConluckYearText;
        public TextView itemConluckYearHealth;
        public TextView itemConluckYearLove;
        public TextView itemConluckYearCareer;
        public TextView itemConluckYearFinance;

        public YearViewHolder(View view) {
            super(view);
            itemConluckYearTitle = (TextView) view.findViewById(R.id.item_conluck_year_title);
            itemConluckYearDate = (TextView) view.findViewById(R.id.item_conluck_year_date);
            itemConluckYearLuckyStone = (TextView) view.findViewById(R.id.item_conluck_year_luckyStone);
            itemConluckYearText = (TextView) view.findViewById(R.id.item_conluck_year_text);
            itemConluckYearHealth = (TextView) view.findViewById(R.id.item_conluck_year_health);
            itemConluckYearLove = (TextView) view.findViewById(R.id.item_conluck_year_love);
            itemConluckYearCareer = (TextView) view.findViewById(R.id.item_conluck_year_career);
            itemConluckYearFinance = (TextView) view.findViewById(R.id.item_conluck_year_finance);
        }
    }
}
