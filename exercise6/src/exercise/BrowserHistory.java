package exercise;

import java.util.ArrayList;

import customexceptions.InvalidPositionException;
import customexceptions.InvalidURLException;
import customexceptions.NoHistoryFoundException;

public class BrowserHistory {
	
	private ArrayList<String> urlHistory;
	private int currentPosition = -1;
	
	BrowserHistory(){
		urlHistory = new ArrayList<>();
	}
	
	void addHistory(String url) throws InvalidURLException {
		boolean endsWithAllowableDomains = false;
		for(String domains : Constants.ALLOWABLEDOMAINS) {
			if(url.endsWith(domains)) {
				endsWithAllowableDomains = true;
				break;
			}
		}
		
		if(!endsWithAllowableDomains) {
			throw new InvalidURLException("Invalid url extension");
		}
		urlHistory.add(url);
	}
	
	String moveBack(int moveBackBy) throws NoHistoryFoundException {
		// called first time
		if(currentPosition == -1) {
			currentPosition = urlHistory.size() - 1;
		}
		
		if(moveBackBy > currentPosition) {
			throw new NoHistoryFoundException("specified history index doesn't exits");
		}else {
			currentPosition -= moveBackBy;
			return urlHistory.get(currentPosition);
		}
	}
	
	String moveForward(int moveForwardBy) throws NoHistoryFoundException {
		// called first time
		if(currentPosition == -1) {
			currentPosition = urlHistory.size() - 1;
		}
		
		if(moveForwardBy + currentPosition >= urlHistory.size()) {
			throw new NoHistoryFoundException("specified history index doesn't exits");
		}else {
			currentPosition += moveForwardBy;
			return urlHistory.get(currentPosition);
		}
	}
	
	void displayHistory() {
		if(urlHistory.isEmpty()) {
			System.out.println("History is empty");
		}else {
			for(int index = 0; index < urlHistory.size(); index++) {
				if(index == currentPosition) {
					System.out.println("=>" + (index+ 1) + " " + urlHistory.get(index));
				}else {
					System.out.println((index+ 1) + " " + urlHistory.get(index));
				}
			}
		}
	}
	
	String getUrl(int index) throws InvalidPositionException {
		if(index < 0) {
			throw new InvalidPositionException("Provide only positive values");
		}
		return urlHistory.get(index);
	}
}
