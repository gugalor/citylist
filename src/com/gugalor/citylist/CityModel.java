package com.gugalor.citylist;

/**
 * 城市属性实体类
 * @author gugalor
 *
 */
public class CityModel
{
	private String CityName; //城市名字
	private String NameSort; //城市首字母

	public String getCityName()
	{
		return CityName;
	}

	public void setCityName(String cityName)
	{
		CityName = cityName;
	}

	public String getNameSort()
	{
		return NameSort;
	}

	public void setNameSort(String nameSort)
	{
		NameSort = nameSort;
	}

}
