package com.futurethought.snaprecycler;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by josh.mieczkowski on 12/14/2015.
 */
public class ChildSizes implements Parcelable {
    private int width;
    private int height;
    private int start;
    private int middle;
    private int end;

    public ChildSizes(View child, int orientation) {
        if (orientation == AutoSizeColumns.VERTICAL) {
            handleVertical(child);
        } else {
            handleHorizontal(child);
        }
    }

    private void handleVertical(View child) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        int marginStart = layoutParams.topMargin;
        int marginEnd = layoutParams.bottomMargin;
        height = child.getMeasuredHeight() + marginStart + marginEnd;

        start = (int) child.getY();
        middle = start + (height / 2);
        end = start + width;
    }

    private void handleHorizontal(View child) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
        int marginStart = layoutParams.getMarginStart();
        int marginEnd = layoutParams.getMarginEnd();

        width = child.getMeasuredWidth() + marginStart + marginEnd;

        start = (int) child.getX();
        middle = start + (width / 2);
        end = start + width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getStart() {
        return start;
    }

    public int getMiddle() {
        return middle;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeInt(this.start);
        dest.writeInt(this.middle);
        dest.writeInt(this.end);
    }

    protected ChildSizes(Parcel in) {
        this.width = in.readInt();
        this.height = in.readInt();
        this.start = in.readInt();
        this.middle = in.readInt();
        this.end = in.readInt();
    }

    public static final Parcelable.Creator<ChildSizes> CREATOR = new Parcelable.Creator<ChildSizes>() {
        public ChildSizes createFromParcel(Parcel source) {
            return new ChildSizes(source);
        }

        public ChildSizes[] newArray(int size) {
            return new ChildSizes[size];
        }
    };
}
