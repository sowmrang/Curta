package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.Operator;
import nl.bigo.curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class NotExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        Operator operator = Operator.Not;
        Expression expression = super.expressions.get(operator.type);

        Object[][] tests = {
                {"!false", true},
                {"!true", false}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            assertThat(ast.treeType, is(operator.type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }
}
