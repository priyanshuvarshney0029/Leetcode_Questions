class Solution:
    def isRectangleOverlap(self, rec1: list[int], rec2: list[int]) -> bool:

        x1 = rec1[0]
        y1 = rec1[1]
        x2 = rec1[2]
        y2 = rec1[3]

        a1 = rec2[0]
        b1 = rec2[1]
        a2 = rec2[2]
        b2 = rec2[3]

        if (x1 < a2 and a1 < x2 and
                y1 < b2 and b1 < y2):

            return True

        return False