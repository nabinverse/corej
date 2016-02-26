import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class RecomendedTrainingsFinder {
	
	public List<String> getDritectFriends(String name){
		List<String> friends= new ArrayList<String>();
		return friends;
	}
	
	public List<String> getAttaintedCourseForUser(String user){
		List<String> trainings= new ArrayList<String>();
		//   Set<String> set = new HashSet<String>(list);
		return trainings;
	}
	
	public List<String> findRecomendedTrainings(String name){
		List<String> recomTrainings= new ArrayList<String>();
		Set<String> totalFriendsToScan = new HashSet<String>();
		List<String> myTrains = getAttaintedCourseForUser(name);
	
		totalFriendsToScan.addAll(getDritectFriends(name));
		for(String f:getDritectFriends(name)){
			totalFriendsToScan.addAll(getDritectFriends(f));
		}
		
		List<String> allCoverTrains = new ArrayList<String>();
		for(String f:totalFriendsToScan){
			allCoverTrains.addAll(getAttaintedCourseForUser(f));
		}
		//discard my trainings
		allCoverTrains.removeAll(myTrains);
		
		Map<String,Integer> result = new HashMap<String, Integer>();
		
		int highFre=0;
		for(String t:allCoverTrains){
			if(result.get(t)==null){
				result.put(t, 1);
				if(highFre<1)
					highFre=1;
			}else{
				int fre=result.get(t)+1;
				if(highFre<fre){
					highFre=fre;
				}
				result.put(t, fre);
			}
		}
		
		
		for(int i=highFre;i>0;i--){
			recomTrainings.addAll(getAllTrainOfFre(allCoverTrains,result,i));
		}
		
		return recomTrainings;
	}

	private List<String> getAllTrainOfFre(List<String> allCoverTrains,
			Map<String, Integer> result, int i) {
		
		List<String> retList= new ArrayList<String>();
		
		for(String t:allCoverTrains){
			if(result.get(t)==i){
				retList.add(t);
			}
		}
		
		
		return retList;
	}

}
