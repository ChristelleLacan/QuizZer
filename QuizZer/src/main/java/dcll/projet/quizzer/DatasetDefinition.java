package dcll.projet.quizzer;

import java.util.ArrayList;

public class DatasetDefinition {
	private String name;
	private String status;
	private String type;
	private String distribution;
	private String minimum;
	private String maximum;
	private String decimals;
	private String itemCount;
	private ArrayList<DatasetItem> datasetItems = new ArrayList<DatasetItem>();
	private String numberOfItems;

	public DatasetDefinition(String mName, String mStatus, String mType,
			String mDistribution, String mMinimum, String mMaximum,
			String mDecimals, String mItemCount,
			ArrayList<DatasetItem> mDatasetItems, String mNumberOfItems) {
		name = mName;
		status = mStatus;
		type = mType;
		distribution = mDistribution;
		minimum = mMinimum;
		maximum = mMaximum;
		decimals = mDecimals;
		itemCount = mItemCount;
		datasetItems = mDatasetItems;
		numberOfItems = mNumberOfItems;
	}

	public String toString() {
		return "\n-- Dataset Definition : " + "\n\tStatus : " + status
				+ "\n\tName : " + name + "\n\tType : " + type
				+ "\n\tDistribution : " + distribution + "\n\tMinimum : "
				+ minimum + "\n\tMaximum : " + maximum + "\n\tDecimals : "
				+ decimals + "\n\tItem Count : " + itemCount
				+ "\n\tDataset Items : \n" + datasetItems
				+ "\n\tNumber of Item : " + numberOfItems;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public String getDistribution() {
		return distribution;
	}

	public String getMinimum() {
		return minimum;
	}

	public String getMaximum() {
		return maximum;
	}

	public String getDecimals() {
		return decimals;
	}

	public String getItemCount() {
		return itemCount;
	}

	public ArrayList<DatasetItem> getDatasetItems() {
		return datasetItems;
	}

	public String getNumberOfItems() {
		return numberOfItems;
	}
	
	
}
