


def filter_and_sum(nums:list[int],min_val:int) -> int:

    sommaValori:int = 0

    for elm in nums:

        if elm > min_val:
            sommaValori += elm
    
    return sommaValori


