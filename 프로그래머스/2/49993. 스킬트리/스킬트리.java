class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        for (String str : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {	
                if (skill.contains(String.valueOf(str.charAt(i)))) {
                    sb.append(str.charAt(i));
                }
            }

            if(skill.indexOf(sb.toString()) == 0) {
                count++;
            }
        }
        
        return count;
    }
}