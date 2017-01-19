package com.etn;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;

import java.util.Arrays;

public class Tuto {

	private static final String CLE_GEOCODINGAPI = "AIzaSyBsNZNX4jzEzNbT0hI1Q4b8Na5Vznvp9U0";

	public static void main(String[] a) {
		GeoApiContext context = new GeoApiContext().setApiKey(CLE_GEOCODINGAPI);
		try {
			GeocodingResult[]  results = GeocodingApi.geocode(context, "Centre Cléopâtre, Centre Urbain Nord, Tunis, Tunisie").await();
			GeocodingResult r0 = results[0];
			for(AddressComponent ac : r0.addressComponents) {
				System.out.println("-------------");
				System.out.println(ac.longName);
				System.out.println(ac.shortName);
				for(AddressComponentType act : ac.types) {
					System.out.println(act.toString());
				}
			}
			System.out.println(r0.formattedAddress);
			System.out.println(r0.geometry.location.toUrlValue());
			System.out.println(Arrays.asList(r0.types).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
