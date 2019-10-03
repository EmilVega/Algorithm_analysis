import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SummerTour {

	public int selectProposals(int [] d, int [] a, int [] m, List<Integer> selected){		
		// Copy array m of economical offers into m2 to remove selected proposals
		int [] m2 = Arrays.copyOf(m, m.length);
		
		// First, select the proposal with maximum benefit
		int proposal = maximum(m2);
		selected.add(proposal);
		m2[proposal] = 0;
		
		// Select the proposals with maximum benefit that are not overlapped with the previously selected ones
		boolean end = false;
		while (!end){
			boolean overlapped = true;
			while (overlapped && !end){
				proposal = maximum(m2);
				overlapped = false;
				// Check that is not overlapped by a previous selected proposal				
				Iterator<Integer> it = selected.iterator();				
				while (!overlapped && it.hasNext()){
					int selectedProposal = it.next();
					overlapped = ((d[proposal]==d[selectedProposal]) ||
							((d[proposal]<d[selectedProposal]) && ((d[proposal]+a[proposal]-1)>=d[selectedProposal]))
							|| ((d[proposal]>d[selectedProposal]) && ((d[selectedProposal]+a[selectedProposal]-1)>=d[proposal])));
				}
				if (!overlapped){
					selected.add(proposal); // add the proposal				
				}
				m2[proposal] = 0;
				
				// Check stopping criterion
				int i = 0;
				while (i<m2.length && m2[i]==0){
					i++;
				}
				end = (i>=m2.length);
			}
						
		}
			
		// Compute the benefit for the selected proposals
		int benefit = 0;
		Iterator<Integer> it = selected.iterator();
		while (it.hasNext()){
			benefit += m[it.next()];
		}
		return benefit;
	}
	
	private int maximum(int [] a){
		int max = 0;
		for (int i=1; i<a.length; i++){
			if (a[i]>a[max]){
				max = i;
			}
		}
		return max;
	}
}
