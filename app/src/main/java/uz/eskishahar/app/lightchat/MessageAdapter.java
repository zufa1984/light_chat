package uz.eskishahar.app.lightchat;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<FriendlyMessage> {

    private boolean zoomOut =  false;

    public MessageAdapter(@NonNull Context context, int resource, List<FriendlyMessage> object) {
        super(context, resource, object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }

        ImageView photoImageView = (ImageView) convertView.findViewById(R.id.photoImageView);
        TextView messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView  currentDateTimeView = (TextView) convertView.findViewById(R.id.dateTextView);

        FriendlyMessage message = getItem(position);

        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            messageTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(photoImageView);
        } else {
            messageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }
        authorTextView.setText(message.getName());

        long long1 = message.getTimestamp().get("timestamp");

        String finalTime = getTimeDate(long1);

        currentDateTimeView.setText(finalTime);



        return convertView;
    }

    public static String getTimeDate(long timestamp){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
            Date netDate = (new Date(timestamp));
            return simpleDateFormat.format(netDate);
        } catch(Exception e) {
            return "date";
        }
    }

}
