/* This file was generated by SableCC (http://www.sablecc.org/). */

package parser;

import lexer.*;
import node.*;
import analysis.*;
import java.util.*;

import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

@SuppressWarnings("nls")
public class Parser
{
    public final Analysis ignoredTokens = new AnalysisAdapter();

    protected ArrayList<Object> nodeList;

    private final Lexer lexer;
    private final ListIterator<Object> stack = new LinkedList<Object>().listIterator();
    private int last_pos;
    private int last_line;
    private Token last_token;
    private final TokenIndex converter = new TokenIndex();
    private final int[] action = new int[2];

    private final static int SHIFT = 0;
    private final static int REDUCE = 1;
    private final static int ACCEPT = 2;
    private final static int ERROR = 3;

    public Parser(@SuppressWarnings("hiding") Lexer lexer)
    {
        this.lexer = lexer;
    }

    @SuppressWarnings({"unchecked","unused"})
    private void push(int numstate, ArrayList<Object> listNode) throws ParserException, LexerException, IOException
    {
        this.nodeList = listNode;

        if(!this.stack.hasNext())
        {
            this.stack.add(new State(numstate, this.nodeList));
            return;
        }

        State s = (State) this.stack.next();
        s.state = numstate;
        s.nodes = this.nodeList;
    }

    private int goTo(int index)
    {
        int state = state();
        int low = 1;
        int high = gotoTable[index].length - 1;
        int value = gotoTable[index][0][1];

        while(low <= high)
        {
            // int middle = (low + high) / 2;
            int middle = (low + high) >>> 1;

            if(state < gotoTable[index][middle][0])
            {
                high = middle - 1;
            }
            else if(state > gotoTable[index][middle][0])
            {
                low = middle + 1;
            }
            else
            {
                value = gotoTable[index][middle][1];
                break;
            }
        }

        return value;
    }

    private int state()
    {
        State s = (State) this.stack.previous();
        this.stack.next();
        return s.state;
    }

    private ArrayList<Object> pop()
    {
        return ((State) this.stack.previous()).nodes;
    }

    private int index(Switchable token)
    {
        this.converter.index = -1;
        token.apply(this.converter);
        return this.converter.index;
    }

    @SuppressWarnings("unchecked")
    public Start parse() throws ParserException, LexerException, IOException
    {
        push(0, null);
        List<Node> ign = null;
        while(true)
        {
            while(index(this.lexer.peek()) == -1)
            {
                if(ign == null)
                {
                    ign = new LinkedList<Node>();
                }

                ign.add(this.lexer.next());
            }

            if(ign != null)
            {
                this.ignoredTokens.setIn(this.lexer.peek(), ign);
                ign = null;
            }

            this.last_pos = this.lexer.peek().getPos();
            this.last_line = this.lexer.peek().getLine();
            this.last_token = this.lexer.peek();

            int index = index(this.lexer.peek());
            this.action[0] = Parser.actionTable[state()][0][1];
            this.action[1] = Parser.actionTable[state()][0][2];

            int low = 1;
            int high = Parser.actionTable[state()].length - 1;

            while(low <= high)
            {
                int middle = (low + high) / 2;

                if(index < Parser.actionTable[state()][middle][0])
                {
                    high = middle - 1;
                }
                else if(index > Parser.actionTable[state()][middle][0])
                {
                    low = middle + 1;
                }
                else
                {
                    this.action[0] = Parser.actionTable[state()][middle][1];
                    this.action[1] = Parser.actionTable[state()][middle][2];
                    break;
                }
            }

            switch(this.action[0])
            {
                case SHIFT:
		    {
		        ArrayList<Object> list = new ArrayList<Object>();
		        list.add(this.lexer.next());
                        push(this.action[1], list);
                    }
		    break;
                case REDUCE:
                    {
                        int reduction = this.action[1];
                        if(reduction < 500) reduce_0(reduction);
                    }
                    break;
                case ACCEPT:
                    {
                        EOF node2 = (EOF) this.lexer.next();
                        PExpr node1 = (PExpr) pop().get(0);
                        Start node = new Start(node1, node2);
                        return node;
                    }
                case ERROR:
                    throw new ParserException(this.last_token,
                        "[" + this.last_line + "," + this.last_pos + "] " +
                        Parser.errorMessages[Parser.errors[this.action[1]]]);
            }
        }
    }

    private void reduce_0(int reduction) throws IOException, LexerException, ParserException
    {
        switch(reduction)
        {
            case 0: /* reduce AOrExpr */
            {
                ArrayList<Object> list = new0();
                push(goTo(0), list);
            }
            break;
            case 1: /* reduce AAndExpr */
            {
                ArrayList<Object> list = new1();
                push(goTo(0), list);
            }
            break;
            case 2: /* reduce ANotExpr */
            {
                ArrayList<Object> list = new2();
                push(goTo(0), list);
            }
            break;
            case 3: /* reduce AArithopExpr */
            {
                ArrayList<Object> list = new3();
                push(goTo(0), list);
            }
            break;
            case 4: /* reduce AAddArithop */
            {
                ArrayList<Object> list = new4();
                push(goTo(1), list);
            }
            break;
            case 5: /* reduce ASubArithop */
            {
                ArrayList<Object> list = new5();
                push(goTo(1), list);
            }
            break;
            case 6: /* reduce ARelationArithop */
            {
                ArrayList<Object> list = new6();
                push(goTo(1), list);
            }
            break;
            case 7: /* reduce ALtRelation */
            {
                ArrayList<Object> list = new7();
                push(goTo(2), list);
            }
            break;
            case 8: /* reduce AGteqRelation */
            {
                ArrayList<Object> list = new8();
                push(goTo(2), list);
            }
            break;
            case 9: /* reduce ALteqRelation */
            {
                ArrayList<Object> list = new9();
                push(goTo(2), list);
            }
            break;
            case 10: /* reduce AGtRelation */
            {
                ArrayList<Object> list = new10();
                push(goTo(2), list);
            }
            break;
            case 11: /* reduce AEqRelation */
            {
                ArrayList<Object> list = new11();
                push(goTo(2), list);
            }
            break;
            case 12: /* reduce ANeqRelation */
            {
                ArrayList<Object> list = new12();
                push(goTo(2), list);
            }
            break;
            case 13: /* reduce ATermRelation */
            {
                ArrayList<Object> list = new13();
                push(goTo(2), list);
            }
            break;
            case 14: /* reduce AMulTerm */
            {
                ArrayList<Object> list = new14();
                push(goTo(3), list);
            }
            break;
            case 15: /* reduce ADivTerm */
            {
                ArrayList<Object> list = new15();
                push(goTo(3), list);
            }
            break;
            case 16: /* reduce AFactorTerm */
            {
                ArrayList<Object> list = new16();
                push(goTo(3), list);
            }
            break;
            case 17: /* reduce AParensFactor */
            {
                ArrayList<Object> list = new17();
                push(goTo(4), list);
            }
            break;
            case 18: /* reduce AAsignamefactor1Factor */
            {
                ArrayList<Object> list = new18();
                push(goTo(4), list);
            }
            break;
            case 19: /* reduce AAsignamefactor2Factor */
            {
                ArrayList<Object> list = new19();
                push(goTo(4), list);
            }
            break;
            case 20: /* reduce AAsignumberfactor1Factor */
            {
                ArrayList<Object> list = new20();
                push(goTo(4), list);
            }
            break;
            case 21: /* reduce AAsignumberfactor2Factor */
            {
                ArrayList<Object> list = new21();
                push(goTo(4), list);
            }
            break;
            case 22: /* reduce AStrFactor */
            {
                ArrayList<Object> list = new22();
                push(goTo(4), list);
            }
            break;
            case 23: /* reduce ABoolFactor */
            {
                ArrayList<Object> list = new23();
                push(goTo(4), list);
            }
            break;
            case 24: /* reduce AElementName */
            {
                ArrayList<Object> list = new24();
                push(goTo(5), list);
            }
            break;
            case 25: /* reduce AVarName */
            {
                ArrayList<Object> list = new25();
                push(goTo(5), list);
            }
            break;
            case 26: /* reduce AIntNumber */
            {
                ArrayList<Object> list = new26();
                push(goTo(6), list);
            }
            break;
            case 27: /* reduce AFloatNumber */
            {
                ArrayList<Object> list = new27();
                push(goTo(6), list);
            }
            break;
        }
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new0() /* reduce AOrExpr */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new AOrExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new1() /* reduce AAndExpr */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new AAndExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new2() /* reduce ANotExpr */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        TNot tnotNode2;
        PExpr pexprNode3;
        tnotNode2 = (TNot)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList2.get(0);

        pexprNode1 = new ANotExpr(tnotNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new3() /* reduce AArithopExpr */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        pexprNode1 = (PExpr)nodeArrayList1.get(0);
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new4() /* reduce AAddArithop */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new AAddExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new5() /* reduce ASubArithop */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new ASubExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new6() /* reduce ARelationArithop */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        pexprNode1 = (PExpr)nodeArrayList1.get(0);
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new7() /* reduce ALtRelation */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new ALtExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new8() /* reduce AGteqRelation */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new AGteqExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new9() /* reduce ALteqRelation */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new ALteqExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new10() /* reduce AGtRelation */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new AGtExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new11() /* reduce AEqRelation */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new AEqExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new12() /* reduce ANeqRelation */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new ANeqExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new13() /* reduce ATermRelation */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        pexprNode1 = (PExpr)nodeArrayList1.get(0);
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new14() /* reduce AMulTerm */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new AMulExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new15() /* reduce ADivTerm */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        PExpr pexprNode2;
        PExpr pexprNode3;
        pexprNode2 = (PExpr)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new ADivExpr(pexprNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new16() /* reduce AFactorTerm */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        pexprNode1 = (PExpr)nodeArrayList1.get(0);
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new17() /* reduce AParensFactor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        pexprNode1 = (PExpr)nodeArrayList2.get(0);
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new18() /* reduce AAsignamefactor1Factor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        @SuppressWarnings("unused") Object nullNode2 = null;
        PExpr pexprNode3;
        pexprNode3 = (PExpr)nodeArrayList1.get(0);

        pexprNode1 = new ASignameExpr(null, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new19() /* reduce AAsignamefactor2Factor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        TSub tsubNode2;
        PExpr pexprNode3;
        tsubNode2 = (TSub)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList2.get(0);

        pexprNode1 = new ASignameExpr(tsubNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new20() /* reduce AAsignumberfactor1Factor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        @SuppressWarnings("unused") Object nullNode2 = null;
        PExpr pexprNode3;
        pexprNode3 = (PExpr)nodeArrayList1.get(0);

        pexprNode1 = new ASignumberExpr(null, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new21() /* reduce AAsignumberfactor2Factor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        TSub tsubNode2;
        PExpr pexprNode3;
        tsubNode2 = (TSub)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList2.get(0);

        pexprNode1 = new ASignumberExpr(tsubNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new22() /* reduce AStrFactor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        TStrVal tstrvalNode2;
        tstrvalNode2 = (TStrVal)nodeArrayList1.get(0);

        pexprNode1 = new AStrExpr(tstrvalNode2);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new23() /* reduce ABoolFactor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        TBoolVal tboolvalNode2;
        tboolvalNode2 = (TBoolVal)nodeArrayList1.get(0);

        pexprNode1 = new ABoolExpr(tboolvalNode2);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new24() /* reduce AElementName */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList4 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        TIdentifier tidentifierNode2;
        PExpr pexprNode3;
        tidentifierNode2 = (TIdentifier)nodeArrayList1.get(0);
        pexprNode3 = (PExpr)nodeArrayList3.get(0);

        pexprNode1 = new AElementExpr(tidentifierNode2, pexprNode3);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new25() /* reduce AVarName */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        TIdentifier tidentifierNode2;
        tidentifierNode2 = (TIdentifier)nodeArrayList1.get(0);

        pexprNode1 = new AVarExpr(tidentifierNode2);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new26() /* reduce AIntNumber */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        TIntVal tintvalNode2;
        tintvalNode2 = (TIntVal)nodeArrayList1.get(0);

        pexprNode1 = new AIntExpr(tintvalNode2);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new27() /* reduce AFloatNumber */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpr pexprNode1;
        {
            // Block
        TFloatVal tfloatvalNode2;
        tfloatvalNode2 = (TFloatVal)nodeArrayList1.get(0);

        pexprNode1 = new AFloatExpr(tfloatvalNode2);
        }
	nodeList.add(pexprNode1);
        return nodeList;
    }



    private static int[][][] actionTable;
/*      {
			{{-1, ERROR, 0}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, {31, SHIFT, 8}, },
			{{-1, REDUCE, 25}, {23, SHIFT, 16}, },
			{{-1, REDUCE, 26}, },
			{{-1, REDUCE, 27}, },
			{{-1, REDUCE, 23}, },
			{{-1, REDUCE, 22}, },
			{{-1, ERROR, 6}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, },
			{{-1, ERROR, 7}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, {31, SHIFT, 8}, },
			{{-1, ERROR, 8}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 9}, {8, SHIFT, 21}, {9, SHIFT, 22}, {42, ACCEPT, -1}, },
			{{-1, REDUCE, 3}, {10, SHIFT, 23}, {11, SHIFT, 24}, },
			{{-1, REDUCE, 6}, {16, SHIFT, 25}, {17, SHIFT, 26}, {18, SHIFT, 27}, {19, SHIFT, 28}, {20, SHIFT, 29}, {21, SHIFT, 30}, },
			{{-1, REDUCE, 13}, {12, SHIFT, 31}, {13, SHIFT, 32}, },
			{{-1, REDUCE, 16}, },
			{{-1, REDUCE, 18}, },
			{{-1, REDUCE, 20}, },
			{{-1, ERROR, 16}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, {31, SHIFT, 8}, },
			{{-1, REDUCE, 19}, },
			{{-1, REDUCE, 21}, },
			{{-1, ERROR, 19}, {8, SHIFT, 21}, {9, SHIFT, 22}, {15, SHIFT, 34}, },
			{{-1, REDUCE, 2}, {10, SHIFT, 23}, {11, SHIFT, 24}, },
			{{-1, ERROR, 21}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 22}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 23}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 24}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 25}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 26}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 27}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 28}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 29}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 30}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 31}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 32}, {0, SHIFT, 1}, {1, SHIFT, 2}, {2, SHIFT, 3}, {3, SHIFT, 4}, {4, SHIFT, 5}, {11, SHIFT, 6}, {14, SHIFT, 7}, },
			{{-1, ERROR, 33}, {8, SHIFT, 21}, {9, SHIFT, 22}, {24, SHIFT, 47}, },
			{{-1, REDUCE, 17}, },
			{{-1, REDUCE, 0}, {10, SHIFT, 23}, {11, SHIFT, 24}, },
			{{-1, REDUCE, 1}, {10, SHIFT, 23}, {11, SHIFT, 24}, },
			{{-1, REDUCE, 4}, {16, SHIFT, 25}, {17, SHIFT, 26}, {18, SHIFT, 27}, {19, SHIFT, 28}, {20, SHIFT, 29}, {21, SHIFT, 30}, },
			{{-1, REDUCE, 5}, {16, SHIFT, 25}, {17, SHIFT, 26}, {18, SHIFT, 27}, {19, SHIFT, 28}, {20, SHIFT, 29}, {21, SHIFT, 30}, },
			{{-1, REDUCE, 7}, {12, SHIFT, 31}, {13, SHIFT, 32}, },
			{{-1, REDUCE, 9}, {12, SHIFT, 31}, {13, SHIFT, 32}, },
			{{-1, REDUCE, 10}, {12, SHIFT, 31}, {13, SHIFT, 32}, },
			{{-1, REDUCE, 8}, {12, SHIFT, 31}, {13, SHIFT, 32}, },
			{{-1, REDUCE, 12}, {12, SHIFT, 31}, {13, SHIFT, 32}, },
			{{-1, REDUCE, 11}, {12, SHIFT, 31}, {13, SHIFT, 32}, },
			{{-1, REDUCE, 14}, },
			{{-1, REDUCE, 15}, },
			{{-1, REDUCE, 24}, },
        };*/
    private static int[][][] gotoTable;
/*      {
			{{-1, 9}, {7, 19}, {16, 33}, },
			{{-1, 10}, {8, 20}, {21, 35}, {22, 36}, },
			{{-1, 11}, {23, 37}, {24, 38}, },
			{{-1, 12}, {25, 39}, {26, 40}, {27, 41}, {28, 42}, {29, 43}, {30, 44}, },
			{{-1, 13}, {31, 45}, {32, 46}, },
			{{-1, 14}, {6, 17}, },
			{{-1, 15}, {6, 18}, },
        };*/
    private static String[] errorMessages;
/*      {
			"expecting: identifier, int val, float val, bool val, str val, '-', '(', 'not'",
			"expecting: '|', '&', '+', '-', '*', '/', ')', '<', '<=', '>', '>=', '!=', '=', '[', ']', EOF",
			"expecting: '|', '&', '+', '-', '*', '/', ')', '<', '<=', '>', '>=', '!=', '=', ']', EOF",
			"expecting: identifier, int val, float val",
			"expecting: identifier, int val, float val, bool val, str val, '-', '('",
			"expecting: '|', '&', EOF",
			"expecting: '|', '&', '+', '-', ')', ']', EOF",
			"expecting: '|', '&', '+', '-', ')', '<', '<=', '>', '>=', '!=', '=', ']', EOF",
			"expecting: '|', '&', ')'",
			"expecting: '|', '&', ']'",
        };*/
    private static int[] errors;
/*      {
			0, 1, 2, 2, 2, 2, 3, 0, 4, 5, 6, 7, 2, 2, 2, 2, 0, 2, 2, 8, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 9, 2, 6, 6, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 
        };*/

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Parser.class.getResourceAsStream("parser.dat")));

            // read actionTable
            int length = s.readInt();
            Parser.actionTable = new int[length][][];
            for(int i = 0; i < Parser.actionTable.length; i++)
            {
                length = s.readInt();
                Parser.actionTable[i] = new int[length][3];
                for(int j = 0; j < Parser.actionTable[i].length; j++)
                {
                for(int k = 0; k < 3; k++)
                {
                    Parser.actionTable[i][j][k] = s.readInt();
                }
                }
            }

            // read gotoTable
            length = s.readInt();
            gotoTable = new int[length][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][2];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                for(int k = 0; k < 2; k++)
                {
                    gotoTable[i][j][k] = s.readInt();
                }
                }
            }

            // read errorMessages
            length = s.readInt();
            errorMessages = new String[length];
            for(int i = 0; i < errorMessages.length; i++)
            {
                length = s.readInt();
                StringBuffer buffer = new StringBuffer();

                for(int j = 0; j < length; j++)
                {
                buffer.append(s.readChar());
                }
                errorMessages[i] = buffer.toString();
            }

            // read errors
            length = s.readInt();
            errors = new int[length];
            for(int i = 0; i < errors.length; i++)
            {
                errors[i] = s.readInt();
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"parser.dat\" is either missing or corrupted.");
        }
    }
}