

package taller4

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestMultiplicacionMatriz extends AnyFunSuite{

     test("multiMatriz #1"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1));
        val m2 = Vector(Vector(2));
        val m3 = Vector(Vector(2));
        assert(m3 == obj.multMatriz(m1, m2));
    }

    test("multiMatriz #2"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2), Vector(3,4));
        val m2 = Vector(Vector(5,6), Vector(7,8));
        val m3 = Vector(Vector(19,22), Vector(43,50));
        assert(m3 == obj.multMatriz(m1, m2));
    }
    test("multiMatriz #3"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2,3,4), Vector(5,6,7,8), Vector(9,10,11,12), Vector(13,14,15,16));
        val m2 = Vector(Vector(17,18,19,20), Vector(21,22,23,24), Vector(25,26,27,28), Vector(29,30,31,32));
        val m3 = Vector(Vector(250,260,270,280), Vector(618,644,670,696), Vector(986,1028,1070,1112), Vector(1354,1412,1470,1528));
        assert(m3 == obj.multMatriz(m1, m2));
    }

    test("multiMatriz #4"){
        val obj = new MultiplicacionMatriz();
        
        val m1 = Vector(Vector(7,	80,	3,	37,	9,	60,	92,	35),
        Vector(62,	67,	54,	52,	2,	59,	22,	72),
        Vector(63,	33,	63,	68,	35,	77,	87,	6),
        Vector(6,	97,	79,	64,	33,	34,	54,	61),
        Vector(34,	81,	18,	71,	74,	35,	75,	3),
        Vector(82,	20,	49,	39,	27,	39,	44,	47),
        Vector(18,	56,	2,	25,	27,	52,	62,	15),
        Vector(51,	4,	14,	87,	32,	1,	12,	29));

        val m2 = Vector(Vector(30,	74,	78,	21,	33,	22,	96,	66),
        Vector(47,	34,	61,	68,	100,	83,	82,	42),
        Vector(1,	82,	7,	90,	32,	8,	3,	31),
        Vector(34,	26,	77,	11,	18,	7,	4,	23),
        Vector(13,	16,	39,	80,	9,	51,	49,	90),
        Vector(40,	55,	13,	91,	4,	52,	63,	57),
        Vector(63,	47,	10,	30,	100,	61,	52,	91),
        Vector(28,	81,	67,	49,	22,	66,	70,	35));

        val m3 =  Vector(Vector(14524,	15049,	12692,	16919,	19284,	18578,	18844,	18593),
        Vector(12619,	22789,	19194,	21007,	15448,	16985,	21815,	17841),
        Vector(15000,	22088,	16242,	22696,	18074,	16597,	20725,	24727),
        Vector(13893,	21761,	18222,	24879,	20753,	20034,	19860,	20348),
        Vector(14430,	15469,	17478,	20125,	19448,	18479,	20185,	23422),
        Vector(10774,	20232,	16111,	17253,	12809,	13320,	19173,	18970),
        Vector(10781,	11471,	10113,	14128,	13689,	14088,	15299,	15738),
        Vector(6714,	10800,	14343,	7992,	6227,	6505,	9899,	11013));
    assert(m3 == obj.multMatriz(m1, m2));
    }

      test("multiMatrizPar #1"){
        val obj = new MultiplicacionMatriz();
         val m1 = Vector(Vector(1));
        val m2 = Vector(Vector(2));
        val m3 = Vector(Vector(2));
        assert(m3 == obj.multMatrizPar(m1, m2));
    }
   
    
    test("multiMatrizPar #2"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2), Vector(3,4));
        val m2 = Vector(Vector(5,6), Vector(7,8));
        val m3 = Vector(Vector(19,22), Vector(43,50));
        assert(m3 == obj.multMatrizPar(m1, m2));
    }

    test("multiMatrizPar #3"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2,3,4), Vector(5,6,7,8), Vector(9,10,11,12), Vector(13,14,15,16));
        val m2 = Vector(Vector(17,18,19,20), Vector(21,22,23,24), Vector(25,26,27,28), Vector(29,30,31,32));
        val m3 = Vector(Vector(250,260,270,280), Vector(618,644,670,696), Vector(986,1028,1070,1112), Vector(1354,1412,1470,1528));
        assert(m3 == obj.multMatrizPar(m1, m2));
    }

   test("multiMatrizPar #4"){
        val obj = new MultiplicacionMatriz();
        
        val m1 = Vector(Vector(7,	80,	3,	37,	9,	60,	92,	35),
        Vector(62,	67,	54,	52,	2,	59,	22,	72),
        Vector(63,	33,	63,	68,	35,	77,	87,	6),
        Vector(6,	97,	79,	64,	33,	34,	54,	61),
        Vector(34,	81,	18,	71,	74,	35,	75,	3),
        Vector(82,	20,	49,	39,	27,	39,	44,	47),
        Vector(18,	56,	2,	25,	27,	52,	62,	15),
        Vector(51,	4,	14,	87,	32,	1,	12,	29));

        val m2 = Vector(Vector(30,	74,	78,	21,	33,	22,	96,	66),
        Vector(47,	34,	61,	68,	100,	83,	82,	42),
        Vector(1,	82,	7,	90,	32,	8,	3,	31),
        Vector(34,	26,	77,	11,	18,	7,	4,	23),
        Vector(13,	16,	39,	80,	9,	51,	49,	90),
        Vector(40,	55,	13,	91,	4,	52,	63,	57),
        Vector(63,	47,	10,	30,	100,	61,	52,	91),
        Vector(28,	81,	67,	49,	22,	66,	70,	35));

        val m3 =  Vector(Vector(14524,	15049,	12692,	16919,	19284,	18578,	18844,	18593),
        Vector(12619,	22789,	19194,	21007,	15448,	16985,	21815,	17841),
        Vector(15000,	22088,	16242,	22696,	18074,	16597,	20725,	24727),
        Vector(13893,	21761,	18222,	24879,	20753,	20034,	19860,	20348),
        Vector(14430,	15469,	17478,	20125,	19448,	18479,	20185,	23422),
        Vector(10774,	20232,	16111,	17253,	12809,	13320,	19173,	18970),
        Vector(10781,	11471,	10113,	14128,	13689,	14088,	15299,	15738),
        Vector(6714,	10800,	14343,	7992,	6227,	6505,	9899,	11013));
    assert(m3 == obj.multMatrizPar(m1, m2));
    }

  
    
    test("multiMatrizRecursiva #1"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2), Vector(3,4));
        val m2 = Vector(Vector(5,6), Vector(7,8));
        val m3 = Vector(Vector(19,22), Vector(43,50));
        assert(m3 == obj.multMatrizRecursiva(m1, m2));
    }
    test("multiMatrizRecursiva #2"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2,3,4), Vector(5,6,7,8), Vector(9,10,11,12), Vector(13,14,15,16));
        val m2 = Vector(Vector(17,18,19,20), Vector(21,22,23,24), Vector(25,26,27,28), Vector(29,30,31,32));
        val m3 = Vector(Vector(250,260,270,280), Vector(618,644,670,696), Vector(986,1028,1070,1112), Vector(1354,1412,1470,1528));
        assert(m3 == obj.multMatrizRecursiva(m1, m2));
    }

    test("multiMatrizRecursiva #3"){
        val obj = new MultiplicacionMatriz();
        
        val m1 = Vector(Vector(7,	80,	3,	37,	9,	60,	92,	35),
        Vector(62,	67,	54,	52,	2,	59,	22,	72),
        Vector(63,	33,	63,	68,	35,	77,	87,	6),
        Vector(6,	97,	79,	64,	33,	34,	54,	61),
        Vector(34,	81,	18,	71,	74,	35,	75,	3),
        Vector(82,	20,	49,	39,	27,	39,	44,	47),
        Vector(18,	56,	2,	25,	27,	52,	62,	15),
        Vector(51,	4,	14,	87,	32,	1,	12,	29));

        val m2 = Vector(Vector(30,	74,	78,	21,	33,	22,	96,	66),
        Vector(47,	34,	61,	68,	100,	83,	82,	42),
        Vector(1,	82,	7,	90,	32,	8,	3,	31),
        Vector(34,	26,	77,	11,	18,	7,	4,	23),
        Vector(13,	16,	39,	80,	9,	51,	49,	90),
        Vector(40,	55,	13,	91,	4,	52,	63,	57),
        Vector(63,	47,	10,	30,	100,	61,	52,	91),
        Vector(28,	81,	67,	49,	22,	66,	70,	35));

        val m3 =  Vector(Vector(14524,	15049,	12692,	16919,	19284,	18578,	18844,	18593),
        Vector(12619,	22789,	19194,	21007,	15448,	16985,	21815,	17841),
        Vector(15000,	22088,	16242,	22696,	18074,	16597,	20725,	24727),
        Vector(13893,	21761,	18222,	24879,	20753,	20034,	19860,	20348),
        Vector(14430,	15469,	17478,	20125,	19448,	18479,	20185,	23422),
        Vector(10774,	20232,	16111,	17253,	12809,	13320,	19173,	18970),
        Vector(10781,	11471,	10113,	14128,	13689,	14088,	15299,	15738),
        Vector(6714,	10800,	14343,	7992,	6227,	6505,	9899,	11013));
    assert(m3 == obj.multMatrizRecursiva(m1, m2));
    }


    test("multiMatrizRecursivaPar #1"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2), Vector(3,4));
        val m2 = Vector(Vector(5,6), Vector(7,8));
        val m3 = Vector(Vector(19,22), Vector(43,50));
        assert(m3 == obj.multMatrizRecursivaPar(m1, m2));
    }

    test("multiMatrizRecursivaPar #2"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2,3,4), Vector(5,6,7,8), Vector(9,10,11,12), Vector(13,14,15,16));
        val m2 = Vector(Vector(17,18,19,20), Vector(21,22,23,24), Vector(25,26,27,28), Vector(29,30,31,32));
        val m3 = Vector(Vector(250,260,270,280), Vector(618,644,670,696), Vector(986,1028,1070,1112), Vector(1354,1412,1470,1528));
        assert(m3 == obj.multMatrizRecursivaPar(m1, m2));
    }

     test("multiMatrizRecursivaPar #3"){
        val obj = new MultiplicacionMatriz();
        
        val m1 = Vector(Vector(7,	80,	3,	37,	9,	60,	92,	35),
        Vector(62,	67,	54,	52,	2,	59,	22,	72),
        Vector(63,	33,	63,	68,	35,	77,	87,	6),
        Vector(6,	97,	79,	64,	33,	34,	54,	61),
        Vector(34,	81,	18,	71,	74,	35,	75,	3),
        Vector(82,	20,	49,	39,	27,	39,	44,	47),
        Vector(18,	56,	2,	25,	27,	52,	62,	15),
        Vector(51,	4,	14,	87,	32,	1,	12,	29));

        val m2 = Vector(Vector(30,	74,	78,	21,	33,	22,	96,	66),
        Vector(47,	34,	61,	68,	100,	83,	82,	42),
        Vector(1,	82,	7,	90,	32,	8,	3,	31),
        Vector(34,	26,	77,	11,	18,	7,	4,	23),
        Vector(13,	16,	39,	80,	9,	51,	49,	90),
        Vector(40,	55,	13,	91,	4,	52,	63,	57),
        Vector(63,	47,	10,	30,	100,	61,	52,	91),
        Vector(28,	81,	67,	49,	22,	66,	70,	35));

        val m3 =  Vector(Vector(14524,	15049,	12692,	16919,	19284,	18578,	18844,	18593),
        Vector(12619,	22789,	19194,	21007,	15448,	16985,	21815,	17841),
        Vector(15000,	22088,	16242,	22696,	18074,	16597,	20725,	24727),
        Vector(13893,	21761,	18222,	24879,	20753,	20034,	19860,	20348),
        Vector(14430,	15469,	17478,	20125,	19448,	18479,	20185,	23422),
        Vector(10774,	20232,	16111,	17253,	12809,	13320,	19173,	18970),
        Vector(10781,	11471,	10113,	14128,	13689,	14088,	15299,	15738),
        Vector(6714,	10800,	14343,	7992,	6227,	6505,	9899,	11013));
        assert(m3 == obj.multMatrizRecursivaPar(m1, m2));
    }

    


    test("multiStrassen #1"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2), Vector(3,4));
        val m2 = Vector(Vector(5,6), Vector(7,8));
        val m3 = Vector(Vector(19,22), Vector(43,50));
        assert(m3 == obj.multStrassen(m1, m2));
    }
    test("multiStrassen #2"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2,3,4), Vector(5,6,7,8), Vector(9,10,11,12), Vector(13,14,15,16));
        val m2 = Vector(Vector(17,18,19,20), Vector(21,22,23,24), Vector(25,26,27,28), Vector(29,30,31,32));
        val m3 = Vector(Vector(250,260,270,280), Vector(618,644,670,696), Vector(986,1028,1070,1112), Vector(1354,1412,1470,1528));
        assert(m3 == obj.multStrassen(m1, m2));
    }

     test("multiStrassen #3"){
        val obj = new MultiplicacionMatriz();
        
        val m1 = Vector(Vector(7,	80,	3,	37,	9,	60,	92,	35),
        Vector(62,	67,	54,	52,	2,	59,	22,	72),
        Vector(63,	33,	63,	68,	35,	77,	87,	6),
        Vector(6,	97,	79,	64,	33,	34,	54,	61),
        Vector(34,	81,	18,	71,	74,	35,	75,	3),
        Vector(82,	20,	49,	39,	27,	39,	44,	47),
        Vector(18,	56,	2,	25,	27,	52,	62,	15),
        Vector(51,	4,	14,	87,	32,	1,	12,	29));

        val m2 = Vector(Vector(30,	74,	78,	21,	33,	22,	96,	66),
        Vector(47,	34,	61,	68,	100,	83,	82,	42),
        Vector(1,	82,	7,	90,	32,	8,	3,	31),
        Vector(34,	26,	77,	11,	18,	7,	4,	23),
        Vector(13,	16,	39,	80,	9,	51,	49,	90),
        Vector(40,	55,	13,	91,	4,	52,	63,	57),
        Vector(63,	47,	10,	30,	100,	61,	52,	91),
        Vector(28,	81,	67,	49,	22,	66,	70,	35));

        val m3 =  Vector(Vector(14524,	15049,	12692,	16919,	19284,	18578,	18844,	18593),
        Vector(12619,	22789,	19194,	21007,	15448,	16985,	21815,	17841),
        Vector(15000,	22088,	16242,	22696,	18074,	16597,	20725,	24727),
        Vector(13893,	21761,	18222,	24879,	20753,	20034,	19860,	20348),
        Vector(14430,	15469,	17478,	20125,	19448,	18479,	20185,	23422),
        Vector(10774,	20232,	16111,	17253,	12809,	13320,	19173,	18970),
        Vector(10781,	11471,	10113,	14128,	13689,	14088,	15299,	15738),
        Vector(6714,	10800,	14343,	7992,	6227,	6505,	9899,	11013));
    assert(m3 == obj.multStrassen(m1, m2));
    }

    test("multiStrassen #4"){
        val obj = new MultiplicacionMatriz();
        val m1 =Vector(Vector(23,	74,	84,	43,	53,	84,	21,	48),
        Vector(93,	64,	66,	27,	8,	67,	73,	26),
        Vector(48,	67,	72,	33,	61,	11,	83,	38),
        Vector(16,	88,	56,	27,	62,	97,	68,	6),
        Vector(32,	50,	7,	21,	2,	51,	49,	53),
        Vector(9,	74,	66,	25,	73,	58,	15,	80),
        Vector(81,	31,	64,	12,	58,	68,	40,	64),
        Vector(58,	9,	64,	61,	76,	36,	24,	26));


        val m2 = Vector(Vector(7,	39,	72,	56,	34,	68,	42,	94),
        Vector(37,	66,	95,	1,	48,	18,	83,	6),
        Vector(60,	56,	28,	35,	30,	58,	48,	80),
        Vector(83,	43,	95,	58,	10,	49,	81,	4),
        Vector(77,	11,	52,	37,	48,	16,	13,	74),
        Vector(63,	9,	70,	68,	20,	49,	89,	91),
        Vector(33,	81,	74,	51,	10,	74,	1,	25),
        Vector(88,	80,	61,	63,	75,	61,	50,	16));


        val m3 =Vector(Vector(25798,	19214,	28241,	18564,	15318,	19321,	25209,	22357),
        Vector(18754,	21392,	29283,	19361,	12888,	23026,	22013,	23444),
        Vector(21347,	22278,	27374,	16821,	14166,	20238,	17461,	19004),
        Vector(22626,	18272,	29057,	17246,	12764,	18386,	22658,	21831),
        Vector(13885,	14533,	19778,	12685,	9489,	13901,	14795,	10814),
        Vector(25646,	18946,	25747,	16788,	16902,	16997,	21839,	19005),
        Vector(22252,	18915,	26349,	20345,	15626,	21490,	20065,	25472),
        Vector(20842,	14247,	22452,	17157,	11492,	17149,	16712,	20786));

        assert(m3 == obj.multStrassen(m1, m2));
    }


    test("multiStrassenPar #1"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2), Vector(3,4));
        val m2 = Vector(Vector(5,6), Vector(7,8));
        val m3 = Vector(Vector(19,22), Vector(43,50));
        assert(m3 == obj.multStrassenPar(m1, m2));
    }

    test("multiStrassenPar #2"){
        val obj = new MultiplicacionMatriz();
        val m1 = Vector(Vector(1,2,3,4), Vector(5,6,7,8), Vector(9,10,11,12), Vector(13,14,15,16));
        val m2 = Vector(Vector(17,18,19,20), Vector(21,22,23,24), Vector(25,26,27,28), Vector(29,30,31,32));
        val m3 = Vector(Vector(250,260,270,280), Vector(618,644,670,696), Vector(986,1028,1070,1112), Vector(1354,1412,1470,1528));
        assert(m3 == obj.multStrassenPar(m1, m2));
    }

     test("multiStrassenPar #3"){
        val obj = new MultiplicacionMatriz();
        
        val m1 = Vector(Vector(7,	80,	3,	37,	9,	60,	92,	35),
        Vector(62,	67,	54,	52,	2,	59,	22,	72),
        Vector(63,	33,	63,	68,	35,	77,	87,	6),
        Vector(6,	97,	79,	64,	33,	34,	54,	61),
        Vector(34,	81,	18,	71,	74,	35,	75,	3),
        Vector(82,	20,	49,	39,	27,	39,	44,	47),
        Vector(18,	56,	2,	25,	27,	52,	62,	15),
        Vector(51,	4,	14,	87,	32,	1,	12,	29));

        val m2 = Vector(Vector(30,	74,	78,	21,	33,	22,	96,	66),
        Vector(47,	34,	61,	68,	100,	83,	82,	42),
        Vector(1,	82,	7,	90,	32,	8,	3,	31),
        Vector(34,	26,	77,	11,	18,	7,	4,	23),
        Vector(13,	16,	39,	80,	9,	51,	49,	90),
        Vector(40,	55,	13,	91,	4,	52,	63,	57),
        Vector(63,	47,	10,	30,	100,	61,	52,	91),
        Vector(28,	81,	67,	49,	22,	66,	70,	35));

        val m3 =  Vector(Vector(14524,	15049,	12692,	16919,	19284,	18578,	18844,	18593),
        Vector(12619,	22789,	19194,	21007,	15448,	16985,	21815,	17841),
        Vector(15000,	22088,	16242,	22696,	18074,	16597,	20725,	24727),
        Vector(13893,	21761,	18222,	24879,	20753,	20034,	19860,	20348),
        Vector(14430,	15469,	17478,	20125,	19448,	18479,	20185,	23422),
        Vector(10774,	20232,	16111,	17253,	12809,	13320,	19173,	18970),
        Vector(10781,	11471,	10113,	14128,	13689,	14088,	15299,	15738),
        Vector(6714,	10800,	14343,	7992,	6227,	6505,	9899,	11013));
    assert(m3 == obj.multStrassenPar(m1, m2));
    }

    test("multiStrassenPar #4"){
        val obj = new MultiplicacionMatriz();
        val m1 =Vector(Vector(23,	74,	84,	43,	53,	84,	21,	48),
        Vector(93,	64,	66,	27,	8,	67,	73,	26),
        Vector(48,	67,	72,	33,	61,	11,	83,	38),
        Vector(16,	88,	56,	27,	62,	97,	68,	6),
        Vector(32,	50,	7,	21,	2,	51,	49,	53),
        Vector(9,	74,	66,	25,	73,	58,	15,	80),
        Vector(81,	31,	64,	12,	58,	68,	40,	64),
        Vector(58,	9,	64,	61,	76,	36,	24,	26));


        val m2 = Vector(Vector(7,	39,	72,	56,	34,	68,	42,	94),
        Vector(37,	66,	95,	1,	48,	18,	83,	6),
        Vector(60,	56,	28,	35,	30,	58,	48,	80),
        Vector(83,	43,	95,	58,	10,	49,	81,	4),
        Vector(77,	11,	52,	37,	48,	16,	13,	74),
        Vector(63,	9,	70,	68,	20,	49,	89,	91),
        Vector(33,	81,	74,	51,	10,	74,	1,	25),
        Vector(88,	80,	61,	63,	75,	61,	50,	16));


        val m3 =Vector(Vector(25798,	19214,	28241,	18564,	15318,	19321,	25209,	22357),
        Vector(18754,	21392,	29283,	19361,	12888,	23026,	22013,	23444),
        Vector(21347,	22278,	27374,	16821,	14166,	20238,	17461,	19004),
        Vector(22626,	18272,	29057,	17246,	12764,	18386,	22658,	21831),
        Vector(13885,	14533,	19778,	12685,	9489,	13901,	14795,	10814),
        Vector(25646,	18946,	25747,	16788,	16902,	16997,	21839,	19005),
        Vector(22252,	18915,	26349,	20345,	15626,	21490,	20065,	25472),
        Vector(20842,	14247,	22452,	17157,	11492,	17149,	16712,	20786));

        assert(m3 == obj.multStrassenPar(m1, m2));
    }

}