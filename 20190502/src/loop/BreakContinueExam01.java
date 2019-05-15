package loop;

class BreakContinueExam01 {
	public static void main(String[] args){
		for(int i = 1; i <= 5; i++){
			if(i == 3) break;
			//if(i == 3) continue;
			System.out.println(i);
		}

		System.out.println("--------------------------------------");
		
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= 5; j++){
				//if(i == 3) break;
				if(i == 3) continue;
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}