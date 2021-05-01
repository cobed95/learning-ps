/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
enum Token {
    TK_CHAR;
    TK_ANY;
    TK_REP;
}

var isMatch = function(s, p) {
    const tokenize = strArr => {
        if (strArr.length === 0) return [];
        else {
            const char = strArr.pop();
            switch (char) {
                case '.': {
                    const tokens = tokenize(strArr);
                    tokens.push({type: Token.TK_ANY});
                    return tokens;
                }
                case '*': {
                    const tokens = tokenize(strArr);
                    const pred = tokens.pop();
                    tokens.push({type: Token.TK_REP, pred})
                    return tokens;
                }
                default: {
                    const tokens = tokenize(strArr);
                    tokens.push({type: Token.TK_CHAR, value: char})
                    return tokens;
                }
            }
        }
    }

    const tokens = tokenize(p.split(''));
    const sSplitted = s.split('');
    return tokens.reduce((acc, curr) => {
        switch (curr.type) {
            case Token.TK_CHAR: {
                const head = sSplitted.pop();
                return acc && head === curr.value;
            }
            case Token.TK_ANY:
                sSplitted.pop();
                return acc;
            case Token.TK_REP: {
                // TODO
                while (sSplitted.length > 0) {
                }
            }
        }
    }, true);
};
