/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty, flip it upside down and
 * turn it into a tree where the original right nodes turned into left leaf nodes.
 * Return the new root.
 * ex) input:   [0, 1, 2, 3, 4]
 *     output:  [3, 4, 1, #, #, 2, 0]
 * @param {number[]}
 * @return {number[]}
 */
const reverseBinaryTree = binaryTree => {
    const getLeftChildIdx = parentIdx => parentIdx === 0 ? parentIdx + 1 : parentIdx + 2;
    const getNewRootIdx = binaryTree => {
        if (binaryTree.length === 0) return -1;
        else if (binaryTree.length % 2 === 0) return binaryTree.length - 1
        else return binaryTree.length - 2;
    };

    const getOriginalRightSibling = leftSiblingIdx => leftSiblingIdx <= 0 ? -1 : leftSiblingIdx + 1;
    const getOriginalParent = leftChildIdx => {
        if (leftChildIdx <= 0) return -1;
        else if (leftChildIdx === 1) return 0;
        else return leftChildIdx - 2;
    };

    const newBinaryTree = [];
    let probe = getNewRootIdx(binaryTree);
    let needsEmptyChildrenForLeft = false;
    while (probe >= 0) {
        newBinaryTree.push(binaryTree[probe]);
        if (needsEmptyChildrenForLeft) {
            newBinaryTree.push('#');
            newBinaryTree.push('#');
        }

        const originalRightSibling = getOriginalRightSibling(probe);
        if (originalRightSibling >= binaryTree.length) {
            newBinaryTree.push('#');
            needsEmptyChildrenForLeft = false;
        } else if (originalRightSibling >= 0){
            newBinaryTree.push(binaryTree[originalRightSibling]);
            needsEmptyChildrenForLeft = true;
        } else {
            needsEmptyChildrenForLeft = false;
        }

        const newProbe = getOriginalParent(probe);
        if (newProbe <= 0) {
            needsEmptyChildrenForLeft = false;
        }

        probe = newProbe;
    }

    return newBinaryTree;
}

const getRandomIntSafe = (min, max) => {
  const minInt = Math.ceil(min);
  const maxInt = Math.ceil(max);

  return Math.floor(Math.random() * (maxInt - minInt)) + minInt;
};

const testCases = [
    [0, 1, 2, 3, 4]
];

for (let i = 0; i < 10; i++) {
    testCases.push(new Array(getRandomIntSafe(0, 10)).fill(0).map((x, idx) => idx));
}

testCases.map(testCase => ({input: testCase, output: reverseBinaryTree(testCase)})).forEach(console.log);

