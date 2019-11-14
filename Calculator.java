import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    public Map<String, Integer> variables;
    public List<Object> answers;
    List<Expression> body;

    public Calculator(List<Expression> body) {
        variables = new HashMap<String, Integer>();
        answers = new ArrayList<Object>();
        this.body = body;
    }

    public Map<String, Integer> run() throws Exception {
        body(body);
        return variables;
    }

    public void body(List<Expression> body) throws Exception {
        for (Expression expression : body) {
            answers.add(expression(expression));
        }
    }

    public Object expression(Expression expression) throws Exception {
        Object left;
        Object right;
        switch (expression.type) {
        case OPERAND:
            return expression.operator.value;
        case UNARY_OPERATOR:
            right = expression(expression.operands.get(0));
            if (right instanceof Integer) {
                switch (expression.operator.type) {
                case PLUS:
                    return +(int) right;
                case MINUS:
                    return -(int) right;
                default:
                    throw new Exception("Calculator が対応していない単項演算子です。");
                }
            } else if (right instanceof Double) {
                switch (expression.operator.type) {
                case PLUS:
                    return +(double) right;
                case MINUS:
                    return -(double) right;
                default:
                    throw new Exception("Calculator が対応していない単項演算子です。");
                }
            }
        case BINARY_OPERATOR:
            left = expression(expression.operands.get(0));
            right = expression(expression.operands.get(1));
            if (left instanceof Integer && right instanceof Integer) {
                switch (expression.operator.type) {
                case PLUS:
                    return (int) left + (int) right;
                case MINUS:
                    return (int) left - (int) right;
                case MULTIPLICATION:
                    return (int) left * (int) right;
                case DIVISION:
                    return (double) (int) left / (double) (int) right;
                case BIT_AND:
                    return (int) left & (int) right;
                case BIT_OR:
                    return (int) left | (int) right;
                default:
                    throw new Exception("計算機がおかしい");
                }
            } else if (left instanceof Double || right instanceof Double) {
                if (left instanceof Integer) {
                    left = (double) (int) left;
                }
                if (right instanceof Integer) {
                    right = (double) (int) right;
                }
                switch (expression.operator.type) {
                case PLUS:
                    return (double) left + (double) right;
                case MINUS:
                    return (double) left - (double) right;
                case MULTIPLICATION:
                    return (double) left * (double) right;
                case DIVISION:
                    return (double) left / (double) right;
                default:
                    throw new Exception("計算機がおかしい");
                }
            } else if (left instanceof Boolean && right instanceof Boolean) {
                switch (expression.operator.type) {
                case AND:
                    return (boolean) left && (boolean) right;
                case OR:
                    return (boolean) left || (boolean) right;
                case BIT_AND:
                    return (boolean) left & (boolean) right;
                case BIT_OR:
                    return (boolean) left | (boolean) right;
                default:
                    throw new Exception("計算機がおかしい");
                }
            } else {
                throw new Exception("Calculator が対応していない二項演算子です。");
            }
        case COMPARSION_OPERATOR:
            left = expression(expression.operands.get(0));
            right = expression(expression.operands.get(1));
            if (left instanceof Integer && right instanceof Integer) {
                switch (expression.operator.type) {
                case EQ:
                    return new ComparisonResult(right, (int) left == (int) right);
                case NE:
                    return new ComparisonResult(right, (int) left != (int) right);
                case LE:
                    return new ComparisonResult(right, (int) left <= (int) right);
                case LT:
                    return new ComparisonResult(right, (int) left < (int) right);
                case GE:
                    return new ComparisonResult(right, (int) left >= (int) right);
                case GT:
                    return new ComparisonResult(right, (int) left > (int) right);
                default:
                    throw new Exception("計算機がおかしい");
                }
            } else if (!(left instanceof ComparisonResult) && (left instanceof Double || right instanceof Double)) {
                if (left instanceof Integer) {
                    left = (double) (int) left;
                }
                if (right instanceof Integer) {
                    right = (double) (int) right;
                }
                switch (expression.operator.type) {
                case EQ:
                    return new ComparisonResult(right, (double) left == (double) right);
                case NE:
                    return new ComparisonResult(right, (double) left != (double) right);
                case LE:
                    return new ComparisonResult(right, (double) left <= (double) right);
                case LT:
                    return new ComparisonResult(right, (double) left < (double) right);
                case GE:
                    return new ComparisonResult(right, (double) left >= (double) right);
                case GT:
                    return new ComparisonResult(right, (double) left > (double) right);
                default:
                    throw new Exception("計算機がおかしい");
                }
            } else if (left instanceof Boolean && right instanceof Boolean) {
                switch (expression.operator.type) {
                case EQ:
                    return new ComparisonResult(right, (boolean) left == (boolean) right);
                case NE:
                    return new ComparisonResult(right, (boolean) left != (boolean) right);
                default:
                    throw new Exception("計算機がおかしい");
                }
            } else if (left instanceof ComparisonResult && ((ComparisonResult) left).comparison instanceof Integer
                    && right instanceof Integer) {
                if (!((ComparisonResult) left).result) {
                    return new ComparisonResult(right, false);
                }
                switch (expression.operator.type) {
                case EQ:
                    return new ComparisonResult(right, (int) ((ComparisonResult) left).comparison == (int) right);
                case NE:
                    return new ComparisonResult(right, (int) ((ComparisonResult) left).comparison != (int) right);
                case LE:
                    return new ComparisonResult(right, (int) ((ComparisonResult) left).comparison <= (int) right);
                case LT:
                    return new ComparisonResult(right, (int) ((ComparisonResult) left).comparison < (int) right);
                case GE:
                    return new ComparisonResult(right, (int) ((ComparisonResult) left).comparison >= (int) right);
                case GT:
                    return new ComparisonResult(right, (int) ((ComparisonResult) left).comparison > (int) right);
                default:
                    throw new Exception("計算機がおかしい");
                }
            } else if (left instanceof ComparisonResult && (right instanceof Double || right instanceof Integer)) {
                if (right instanceof Integer) {
                    right = (double) (int) right;
                }
                if (!((ComparisonResult) left).result) {
                    return new ComparisonResult(right, false);
                }
                switch (expression.operator.type) {
                case EQ:
                    return new ComparisonResult(right, (double) ((ComparisonResult) left).comparison == (double) right);
                case NE:
                    return new ComparisonResult(right, (double) ((ComparisonResult) left).comparison != (double) right);
                case LE:
                    return new ComparisonResult(right, (double) ((ComparisonResult) left).comparison <= (double) right);
                case LT:
                    return new ComparisonResult(right, (double) ((ComparisonResult) left).comparison < (double) right);
                case GE:
                    return new ComparisonResult(right, (double) ((ComparisonResult) left).comparison >= (double) right);
                case GT:
                    return new ComparisonResult(right, (double) ((ComparisonResult) left).comparison > (double) right);
                default:
                    throw new Exception("計算機がおかしい");
                }
            } else {
                throw new Exception(left.getClass().getSimpleName() + " と " + right.getClass().getSimpleName()
                        + "の比較演算子は Calculator が対応していません。");
            }
        default:
        }
        throw new Exception("計算機がおかしい");
    }

}
