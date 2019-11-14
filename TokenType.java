/**
 * トークンの種類を表します。
 */
public enum TokenType {
    /**
     * 関数や変数などを表します。
     */
    ID,
    /**
     * 整数型を表します。
     */
    INTEGER,
    /**
     * 浮動小数点型を表します。
     */
    DOUBLE,
    /**
     * 真理値を表します。
     */
    BOOLEAN,
    /**
     * カンマを表します。
     */
    CHARACTER,
    /**
     * 文字を表します。
     */
    STRING,
    /**
     * 文字列を表します。
     */
    COMMA,
    /**
     * 代入を表します。
     */
    ASSAIGNMENT,
    /**
     * += を表します。
     */
    PLUS_ASSAIGNMENT,
    /**
     * -= を表します。
     */
    MINUS_ASSAIGNMENT,
    /**
     * *= を表します。
     */
    MULTIPLICATION_ASSAIGNMENT,
    /**
     * /= を表します。
     */
    DIVISION_ASSAIGNMENT,
    /**
     * %= を表します。
     */
    MOD_ASSAIGNMENT,
    /**
     * <| を表します。
     */
    PIPE_TO_LEFT,
    /**
     * |> を表します。
     */
    PIPE_TO_RIGHT,
    /**
     * 等号を表します。
     */
    EQ,
    /**
     * 不等号を表します。
     */
    NE,
    /**
     * < を表します。
     */
    LT,
    /**
     * <= を表します。
     */
    LE,
    /**
     * > を表します。
     */
    GT,
    /**
     * >= を表します。
     */
    GE,
    /**
     * ( を表します。
     */
    LPAR,
    /**
     * ) を表します。
     */
    RPAR,
    /**
     * & を表します。
     */
    BIT_AND,
    /**
     * | を表します。
     */
    BIT_OR,
    /**
     * ~ を表します。
     */
    BIT_NOT,
    /**
     * && を表します。
     */
    AND,
    /**
     * || を表します。
     */
    OR,
    /**
     * ! を表します。
     */
    NOT,
    /**
     * ^ を表します。
     */
    XOR,
    /**
     * + を表します。
     */
    PLUS,
    /**
     * - を表します。
     */
    MINUS,
    /**
     * 掛け算を表します。
     */
    MULTIPLICATION,
    /**
     * 割り算を表します。
     */
    DIVISION,
    /**
     * 剰余 を表します。
     */
    MOD,
    /**
     * {@code baremodule}を表します。
     */
    BAREMODULE,
    /**
     * 複文の開始を表します。
     */
    BEGIN,
    /**
     * {@code break}を表します。
     */
    BREAK,
    /**
     * {@code catch}を表します。
     */
    CATCH,
    /**
     * 定数を表します。
     */
    CONST,
    /**
     * {@code continue}を表します。
     */
    CONTINUE,
    /**
     * {@code do}を表します。
     */
    DO,
    /**
     * {@code else}を表します。
     */
    ELSE,
    /**
     * {@code elseif}を表します。
     */
    ELSEIF,
    /**
     * {@code end}を表します。
     */
    END,
    /**
     * {@code export}を表します。
     */
    EXPORT,
    /**
     * {@code finally}を表します。
     */
    FINALLY,
    /**
     * {@code for}を表します。
     */
    FOR,
    /**
     * {@code function}を表します。
     */
    FUNCTION,
    /**
     * {@code global}を表します。
     */
    GLOBAL,
    /**
     * {@code if}を表します。
     */
    IF,
    /**
     * {@code import}を表します。
     */
    IMPORT,
    /**
     * {@code let}を表します。
     */
    LET,
    /**
     * {@code local}を表します。
     */
    LOCAL,
    /**
     * {@code macro}を表します。
     */
    MACRO,
    /**
     * {@code module}を表します。
     */
    MODULE,
    /**
     * {@code quote}を表します。
     */
    QUOTE,
    /**
     * {@code return}を表します。
     */
    RETURN,
    /**
     * {@code struct}を表します。
     */
    STRUCT,
    /**
     * {@code try}を表します。
     */
    TRY,
    /**
     * {@code using}を表します。
     */
    USING,
    /**
     * {@code while}を表します。
     */
    WHILE,
    /**
     * ホワイトスペースを表します。
     */
    WHITESPACE,
    /**
     * 未定義のトークンを表します。
     */
    UNDEFINED,
    /**
     * 改行コードを表します。
     */
    NEW_LINE,
    /**
     * 終わりを表します。
     */
    END_OF_STRING,
}
