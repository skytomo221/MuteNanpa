import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    public Map<String, Integer> variables;
    public Expression answer;
    List<Expression> body;

    public Calculator(List<Expression> body) {
        variables = new HashMap<String, Integer>();
        answer = null;
        this.body = body;
    }

    public Object getAnswerValue() {
        return answer.operator.value;
    }

    public static void promoteToInt8(Expression expression) {
        Object obj = expression.operator.value;
        if (obj instanceof Byte) {
            obj = (byte) obj;
        } else {
            throw new ClassCastException(obj.getClass().getName() + " は Int8 に型変換できません。");
        }
        expression.operator.type = TokenType.INT8;
    }

    public static void promoteToInt16(Expression expression) {
        Object obj = expression.operator.value;
        if (obj instanceof Byte) {
            obj = (short) (byte) obj;
        } else if (obj instanceof Short) {
            obj = (short) obj;
        } else {
            throw new ClassCastException(obj.getClass().getName() + " は Int16 に型変換できません。");
        }
        expression.operator.type = TokenType.INT16;
    }

    public static void promoteToInt32(Expression expression) {
        Object obj = expression.operator.value;
        if (obj instanceof Byte) {
            obj = (int) (byte) obj;
        } else if (obj instanceof Short) {
            obj = (int) (short) obj;
        } else if (obj instanceof Integer) {
            obj = (int) obj;
        } else {
            throw new ClassCastException(obj.getClass().getName() + " は Int32 に型変換できません。");
        }
        expression.operator.type = TokenType.INT32;
    }

    public static void promoteToInt64(Expression expression) {
        Object obj = expression.operator.value;
        if (obj instanceof Byte) {
            obj = (float) (byte) obj;
        } else if (obj instanceof Short) {
            obj = (float) (short) obj;
        } else if (obj instanceof Integer) {
            obj = (float) (int) obj;
        } else if (obj instanceof Long) {
            obj = (float) (long) obj;
        } else {
            throw new ClassCastException(obj.getClass().getName() + " は Int64 に型変換できません。");
        }
        expression.operator.type = TokenType.INT64;
    }

    public static void promoteToFloat32(Expression expression) {
        Object obj = expression.operator.value;
        if (obj instanceof Byte) {
            obj = (float) (byte) obj;
        } else if (obj instanceof Short) {
            obj = (float) (short) obj;
        } else if (obj instanceof Integer) {
            obj = (float) (int) obj;
        } else if (obj instanceof Long) {
            obj = (float) (long) obj;
        } else if (obj instanceof Float) {
            obj = (float) obj;
        } else {
            throw new ClassCastException(obj.getClass().getName() + " は Float32 に型変換できません。");
        }
        expression.operator.type = TokenType.FLOAT32;
    }

    public static void promoteToFloat64(Expression expression) {
        Object obj = expression.operator.value;
        if (obj instanceof Byte) {
            obj = (double) (byte) obj;
        } else if (obj instanceof Short) {
            obj = (double) (short) obj;
        } else if (obj instanceof Integer) {
            obj = (double) (int) obj;
        } else if (obj instanceof Long) {
            obj = (double) (long) obj;
        } else if (obj instanceof Float) {
            obj = (double) (float) obj;
        } else if (obj instanceof Double) {
            obj = (double) obj;
        } else {
            throw new ClassCastException(obj.getClass().getName() + " は Float64 に型変換できません。");
        }
        expression.operator.type = TokenType.FLOAT64;
    }

    public static void promoteToBigInt(Expression expression) {
        Object obj = expression.operator.value;
        if (obj instanceof Byte) {
            obj = new BigDecimal((byte) obj);
        } else if (obj instanceof Short) {
            obj = new BigDecimal((short) obj);
        } else if (obj instanceof Integer) {
            obj = new BigDecimal((int) obj);
        } else if (obj instanceof Long) {
            obj = new BigDecimal((long) obj);
        } else if (obj instanceof String) {
            obj = new BigDecimal((String) obj);
        } else {
            throw new ClassCastException(obj.getClass().getName() + " は BigInt に型変換できません。");
        }
        expression.operator.type = TokenType.BIG_INT;
    }

    public static void promoteToBigFloat(Expression expression) {
        Object obj = expression.operator.value;
        if (obj instanceof Byte) {
            obj = new BigDecimal((byte) obj);
        } else if (obj instanceof Short) {
            obj = new BigDecimal((short) obj);
        } else if (obj instanceof Integer) {
            obj = new BigDecimal((int) obj);
        } else if (obj instanceof Long) {
            obj = new BigDecimal((long) obj);
        } else if (obj instanceof Float) {
            obj = new BigDecimal((float) obj);
        } else if (obj instanceof Double) {
            obj = new BigDecimal((double) obj);
        } else if (obj instanceof String) {
            obj = new BigDecimal((String) obj);
        } else {
            throw new ClassCastException(obj.getClass().getName() + " は BigFloat に型変換できません。");
        }
        expression.operator.type = TokenType.BIG_FLOAT;
    }

    public Expression expression(Expression expression) throws Exception {
        switch (expression.type) {
        case OPERAND:
            return expression;
        case UNARY_OPERATOR:
            Expression operand = expression(expression.operands.get(0));
            Object oov = operand.operator.value;
            Expression answer = new Expression(ExpressionType.OPERAND, null);
            Object aov = answer.operator.value;
            if (oov instanceof BigDecimal) {
                switch (expression.operator.type) {
                case PLUS:
                    aov = ((BigDecimal) oov).plus();
                case MINUS:
                    aov = ((BigDecimal) oov).negate();
                default:
                }
            } else if (oov instanceof Double) {
                switch (expression.operator.type) {
                case PLUS:
                    aov = +(double) oov;
                case MINUS:
                    aov = -(double) oov;
                default:
                }
            } else if (oov instanceof Float) {
                switch (expression.operator.type) {
                case PLUS:
                    aov = +(float) oov;
                case MINUS:
                    aov = -(float) oov;
                default:
                }
            } else if (oov instanceof Long) {
                switch (expression.operator.type) {
                case PLUS:
                    aov = +(long) oov;
                case MINUS:
                    aov = -(long) oov;
                default:
                }
            } else if (oov instanceof Integer) {
                switch (expression.operator.type) {
                case PLUS:
                    aov = +(int) oov;
                case MINUS:
                    aov = -(int) oov;
                default:
                }
            } else if (oov instanceof Short) {
                switch (expression.operator.type) {
                case PLUS:
                    aov = +(short) oov;
                case MINUS:
                    aov = -(short) oov;
                default:
                }
            } else if (oov instanceof Byte) {
                switch (expression.operator.type) {
                case PLUS:
                    aov = +(byte) oov;
                case MINUS:
                    aov = -(byte) oov;
                default:
                }
            } else {
                throw new Exception("Calculator が対応していない単項演算子です。");
            }
            return answer;
        case BINARY_OPERATOR:
            Expression left = expression(expression.operands.get(0));
            Expression right = expression(expression.operands.get(1));
            Object lov = left.operator.value;
            Object rov = right.operator.value;
            answer = new Expression(ExpressionType.OPERAND, null);
            if (left.operator.type == TokenType.BIG_FLOAT || right.operator.type == TokenType.BIG_FLOAT) {
                answer = new Expression(ExpressionType.OPERAND, new Token(TokenType.BIG_FLOAT, null));
                aov = answer.operator.value;
                promoteToBigFloat(left);
                promoteToBigFloat(right);
                switch (expression.operator.type) {
                case MULTIPLICATION:
                    aov = ((BigDecimal) lov).multiply((BigDecimal) rov);
                    break;
                case DIVISION:
                    aov = ((BigDecimal) lov).divide((BigDecimal) rov);
                    break;
                case MOD:
                    aov = ((BigDecimal) lov).remainder((BigDecimal) rov);
                    break;
                case PLUS:
                    aov = ((BigDecimal) lov).add((BigDecimal) rov);
                    break;
                case MINUS:
                    aov = ((BigDecimal) lov).subtract((BigDecimal) rov);
                    break;
                default:
                    throw new Exception("BIG_FLOAT が対応していない二項演算子です。");
                }
            } else if (left.operator.type == TokenType.BIG_INT || right.operator.type == TokenType.BIG_INT) {
                answer = new Expression(ExpressionType.OPERAND, new Token(TokenType.BIG_INT, null));
                aov = answer.operator.value;
                promoteToBigInt(left);
                promoteToBigInt(right);
                switch (expression.operator.type) {
                case MULTIPLICATION:
                    aov = ((BigDecimal) lov).multiply((BigDecimal) rov);
                    break;
                case DIVISION:
                    aov = ((BigDecimal) lov).divide((BigDecimal) rov);
                    break;
                case MOD:
                    aov = ((BigDecimal) lov).remainder((BigDecimal) rov);
                    break;
                case PLUS:
                    aov = ((BigDecimal) lov).add((BigDecimal) rov);
                    break;
                case MINUS:
                    aov = ((BigDecimal) lov).subtract((BigDecimal) rov);
                    break;
                default:
                    throw new Exception("BIG_FLOAT が対応していない二項演算子です。");
                }
            } else if (left.operator.type == TokenType.FLOAT64 || right.operator.type == TokenType.FLOAT64) {
                answer = new Expression(ExpressionType.OPERAND, new Token(TokenType.FLOAT64, null));
                aov = answer.operator.value;
                promoteToFloat64(left);
                promoteToFloat64(right);
                switch (expression.operator.type) {
                case MULTIPLICATION:
                    aov = (double) lov * (double) rov;
                    break;
                case DIVISION:
                    aov = (double) lov / (double) rov;
                    break;
                case MOD:
                    aov = (double) lov % (double) rov;
                    break;
                case PLUS:
                    aov = (double) lov + (double) rov;
                    break;
                case MINUS:
                    aov = (double) lov - (double) rov;
                    break;
                default:
                    throw new Exception("BIG_FLOAT が対応していない二項演算子です。");
                }
            } else if (left.operator.type == TokenType.FLOAT32 || right.operator.type == TokenType.FLOAT32) {
            } else if (left.operator.type == TokenType.CHAR || right.operator.type == TokenType.CHAR) {
            } else if (left.operator.type == TokenType.STRING || right.operator.type == TokenType.STRING) {
            } else if (left.operator.type == TokenType.INT64 || right.operator.type == TokenType.INT64) {
            } else if (left.operator.type == TokenType.INT32 || right.operator.type == TokenType.INT32) {
            } else if (left.operator.type == TokenType.INT16 || right.operator.type == TokenType.INT16) {
            } else if (left.operator.type == TokenType.INT8 || right.operator.type == TokenType.INT8) {
            } else if (left.operator.type == TokenType.BOOL || right.operator.type == TokenType.BOOL) {
            }
            return answer;
        case COMPARSION_OPERATOR:
            left = expression(expression.operands.get(0));
            right = expression(expression.operands.get(1));
        default:
        }
        throw new Exception("計算機がおかしい");
    }

    public void body(List<Expression> body) throws Exception {
        for (Expression expression : body) {
            answer = expression(expression);
        }
    }

    public Map<String, Integer> run() throws Exception {
        body(body);
        return variables;
    }
}
