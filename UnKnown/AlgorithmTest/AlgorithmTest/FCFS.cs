using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    class FCFS
    {
        private List<ProcessData> data;

        public FCFS(List<ProcessData> pre_data)
        {
            this.data = new List<ProcessData>();
            this.data = pre_data;

            working();
        }

        public void working()
        {
            // no work
        }

        public double avg_wait()
        {
            return Convert.ToDouble(data[1].pid) * Convert.ToDouble(data[1].arrived_time);
        }

        public double avg_return()
        {
            return 0.0;
        }
    }
}
