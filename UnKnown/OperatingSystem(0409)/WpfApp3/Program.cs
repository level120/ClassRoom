using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Altest
{
    class Program
    {
        static void Main(string[] args)
        {
            // Algorithm name()
            TestCase test = new TestCase();

            test.check();

            FCFS fcfs = new FCFS(test.data);

            test.check();

            Console.WriteLine("평균대기시간 : " + fcfs.avg_wait());
            Console.WriteLine("평균반환시간 : " + fcfs.avg_return());
            Console.WriteLine();
        }
    }
}
