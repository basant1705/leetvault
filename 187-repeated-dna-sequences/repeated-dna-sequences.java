class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> seen = new HashSet<>();
        Set<String> answer = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {

            String sequence = s.substring(i, i + 10);

            if (seen.contains(sequence)) {
                answer.add(sequence);
            } else {
                seen.add(sequence);
            }
        }

        return new ArrayList<>(answer);
    }
}