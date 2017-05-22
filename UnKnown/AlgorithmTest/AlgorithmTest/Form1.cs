using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace AlgorithmTest
{
    public partial class Form1 : Form
    {
        private List<ProcessData> data;

        private bool flag;

        public Form1()
        {
            InitializeComponent();

            Init_user();
        }

        private void Init_user()
        {
            dataProcess.ColumnCount = 5;

            dataProcess.Columns[ 0 ].Name = "no";
            dataProcess.Columns[ 1 ].Name = "PID";
            dataProcess.Columns[ 2 ].Name = "Priority";
            dataProcess.Columns[ 3 ].Name = "Arrived Time";
            dataProcess.Columns[ 4 ].Name = "Service Time";

            data = new List<ProcessData>();

            flag = true;
        }

        private void btnRun_Click( object sender, EventArgs e )
        {
            try
            {
                data.Clear();
                rand();
                renew();
                flag = true;
            }
            catch { }
        }

        private void renew()
        {
            dataProcess.Rows.Clear();

            for ( int i = 0; i < data.Count; i++ )
            {
                dataProcess.Rows.Add( new string[] { data[ i ].no, data[i].pid, data[i].priority, data[i].arrived_time, data[i].service_time } );
            }

            dataProcess.Refresh();
        }

        private void rand()
        {
            Random r = new Random();

            for ( int i = 0, limit = Convert.ToInt32(tbProcess.Text); i < limit; i++ )
            {
                data.Add( new ProcessData( new string[] { "" + ( i + 1 ), "" + ( Common.START_PID + i ), "" + r.Next( 10 ), "" + r.Next( 10 ), "" + ( r.Next( 9 ) + 1 ) } ) );
            }
        }

        private void common_init()
        {
            processChart.Series.Clear();
        }

        private void draw_chart(List<ProcessData> temp)
        {
            Series seriesGantt = new Series();
            seriesGantt.ChartType = SeriesChartType.RangeBar;

            seriesGantt.YValuesPerPoint = 2;

            for ( int i = 0; i < temp.Count; i++ )
            {
                //Console.WriteLine( temp[ i ].no + "\t" + temp[ i ].pid + "\t" + temp[ i ].priority + "t" + temp[ i ].arrived_time + "\t" + temp[ i ].service_time );
                if ( temp[ i ].pid != "" && temp[ i ].arrived_time != "" && temp[ i ].service_time != "" )
                    seriesGantt.Points.AddXY( Convert.ToInt32( temp[ i ].pid ), Convert.ToInt32( temp[ i ].arrived_time ), ( Convert.ToInt32( temp[ i ].arrived_time ) + Convert.ToInt32( temp[ i ].service_time ) ) );
            }

            processChart.Series.Add( seriesGantt );
            processChart.Update();
        }

        private void btnFCFS_Click( object sender, EventArgs e )
        {
            if ( flag )
            {
                common_init();

                FCFS f = new FCFS( data );
                List<ProcessData> res = f.working();
                draw_chart( res );
                MessageBox.Show( "대기시간 : " + f.avg_wait() + " ms\n반환시간 : " + f.avg_return() + " ms", "Result" );
                flag = false;
            }
        }

        private void btnSJF_Click( object sender, EventArgs e )
        {
            if ( flag )
            {
                common_init();

                SJF s = new SJF( data );
                List<ProcessData> res = s.working();
                draw_chart( res );
                MessageBox.Show( "대기시간 : " + s.avg_wait() + " ms\n반환시간 : " + s.avg_return() + " ms", "Result" );
                flag = false;
            }
        }

        private void btnSRT_Click( object sender, EventArgs e )
        {
            if ( flag )
            {
                common_init();

                SRT s = new SRT( data );
                List<ProcessData> res = s.working();
                draw_chart( res );
                MessageBox.Show( "대기시간 : " + s.avg_wait() + " ms\n반환시간 : " + s.avg_return() + " ms", "Result" );
                flag = false;
            }
        }

        private void btnHRN_Click( object sender, EventArgs e )
        {
            if ( flag )
            {
                common_init();

                HRN h = new HRN( data );
                List<ProcessData> res = h.working();
                draw_chart( res );
                MessageBox.Show( "대기시간 : " + h.avg_wait() + " ms\n반환시간 : " + h.avg_return() + " ms", "Result" );
                flag = false;
            }
        }

        private void btnPrio_Click( object sender, EventArgs e )
        {
            if ( flag )
            {
                common_init();

                Priority p = new Priority( data );
                List<ProcessData> res = p.working();
                draw_chart( res );
                MessageBox.Show( "대기시간 : " + p.avg_wait() + " ms\n반환시간 : " + p.avg_return() + " ms", "Result" );
                flag = false;
            }
        }

        private void btnRRB_Click( object sender, EventArgs e )
        {
            if ( flag )
            {
                common_init();

                RoundRobin r = new RoundRobin( data, 1 );
                List<ProcessData> res = r.working();
                draw_chart( res );
                MessageBox.Show( "대기시간 : " + r.avg_wait() + " ms\n반환시간 : " + r.avg_return() + " ms", "Result" );
                flag = false;
            }
        }
    }
}
