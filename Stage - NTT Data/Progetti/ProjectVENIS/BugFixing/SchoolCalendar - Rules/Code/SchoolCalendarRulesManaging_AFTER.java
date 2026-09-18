
/**
  ?BE After (Validator Implementation with O(1) complexity)
 *
 * Following the refactoring, a dedicated domain validator was introduced. 
 * By leveraging the HashSet data structure, uniqueness verification occurs 
 * in constant time O(1), blocking duplicate sort orders and exact date 
 * collisions while permitting logical overlaps.

 */

// ?AFTER: Domain Guard implementation using HashSet for O(1) duplicate detection
public void validateRulesDuplicates(List<SchoolCalendarRuleDTO> rules) {
    Set<Integer> sortOrders = new HashSet<>();
    Set<String> singleDateKeys = new HashSet<>();
    Set<String> intervalKeys = new HashSet<>();

    for (SchoolCalendarRuleDTO rule : rules) {
        // *CHECK: Strict Uniqueness on sortOrder
        if (!sortOrders.add(rule.getSortOrder())) {
            throw new ValidationException("The sort order " + rule.getSortOrder() + " is already in use.");
        }

        // *CHECK: Single Date duplicate check
        if (rule.getSingleDate() != null) {
            String key = rule.getRuleType() + "_" + rule.getSingleDate();
            if (!singleDateKeys.add(key)) {
                throw new ValidationException("An identical rule already exists for this date.");
            }
        }
        // *... (Similar logic applied for date intervals)
    }
}
