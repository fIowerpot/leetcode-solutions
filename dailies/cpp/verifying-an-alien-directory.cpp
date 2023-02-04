class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        unordered_map<char, int> charOrder;
        for (int i = 0; i < order.size(); ++i) {
            charOrder[order[i]] = i;
        }
        for (int i = 1; i < words.size(); ++i) {
            bool isSorted = false;
            int minLength = min(words[i - 1].size(), words[i].size());
            for (int j = 0; j < minLength; ++j) {
                if (charOrder[words[i - 1][j]] < charOrder[words[i][j]]) {
                    isSorted = true;
                    break;
                }
                if (charOrder[words[i - 1][j]] > charOrder[words[i][j]]) {
                    return false;
                }
            }
            if (!isSorted && words[i - 1].size() > words[i].size()) {
                return false;
            }
        }
        return true;
    }
};
