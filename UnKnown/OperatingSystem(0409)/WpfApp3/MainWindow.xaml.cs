using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Forms.Integration;
using System.Windows.Forms.DataVisualization.Charting;
using System.ComponentModel;

namespace WpfApp3
{
    /// <summary>
    /// MainWindow.xaml에 대한 상호 작용 논리
    /// </summary>
    public partial class MainWindow : Window
    {
        List<ProcessData> data;
        string processCount;
        //WindowsFormsHost windowsFormsHost;
        //Chart chart;

        public MainWindow()
        {
            InitializeComponent();
            initialize();
        }

        private void initialize()
        {
            data = new List<ProcessData>();
            chart1.ChartAreas.Add("ChartArea");

            /* Binding */
            this.DataContext = new ProcCnt();

            /* DataGrid 편집 여부 */
            RightControl.ProcessTable.IsReadOnly = ToggleCheck.IsChecked = true;

            /* 붙여넣기 방지 */
            TBPSCount.CommandBindings.Add(new CommandBinding(ApplicationCommands.Paste, tb_Right_Click));

            /* TextBox 한글 막기 */
            InputMethod.SetIsInputMethodEnabled(this.TBPSCount, false);
        }

        /* Chart Update */
        private void ChartUpdate(int number)
        {
            chart1.Series.Clear();

            Series seriesGantt = new Series();
            seriesGantt.ChartType = SeriesChartType.RangeBar;
                        
            seriesGantt.YValuesPerPoint = 2;
            
            for (int i = 0; i < number; i++)
            {
                if (data[i].pid != "" && data[i].arrived_time != "" || data[i].service_time != "")
                    seriesGantt.Points.AddXY(Convert.ToInt32(data[i].pid), Convert.ToInt32(data[i].arrived_time), (Convert.ToInt32(data[i].arrived_time) + Convert.ToInt32(data[i].service_time)));
            }
            
            chart1.Series.Add(seriesGantt);
            chart1.Update();
        }

        /* tb_rule() 과 tb_Right_Click 은 textbox 의 정책 */
        private void tb_rule(object sender, TextCompositionEventArgs e)
        {
            foreach (char c in e.Text)
            {
                if (!char.IsDigit(c))
                {
                    e.Handled = true;
                    break;
                }
            }
        }

        private void tb_Right_Click(object sender, ExecutedRoutedEventArgs e)
        {
            e.Handled = true;
        }

        /* DataGrid IsReadOnly Changing */
        private void ToggleCheck_Checked(object sender, RoutedEventArgs e)
        {
            if (ToggleCheck.IsChecked)
            {
                RightControl.ProcessTable.IsReadOnly = ToggleCheck.IsChecked;

                DataGridAndChartWorking();
            }
        }

        private void ToggleCheck_Unchecked(object sender, RoutedEventArgs e)
        {
            if (!ToggleCheck.IsChecked)
            {
                RightControl.ProcessTable.IsReadOnly = ToggleCheck.IsChecked;
                RightControl.PTHeader1.IsReadOnly = RightControl.PTHeader2.IsReadOnly = true;

                DataGridAndChartWorking();
            }
        }

        /* Data And Chart Update */
        private void DataGridAndChartWorking()
        {
            if (processCount != null && processCount != "")
            {
                int number = Convert.ToInt32(processCount);
                CreateTables(number);

                try
                {
                    ChartUpdate(number);
                }
                catch (Exception err)
                {
                    Console.WriteLine(err);
                }
            }
        }

        /* TextBox ViewModel 연결해서 값 바꿈 */
        private void TBPSCount_TextChanged(object sender, TextChangedEventArgs e)
        {
            var viewModel = this.DataContext as ProcCnt;
            processCount = viewModel.processCount;

            try
            {
                DataGridAndChartWorking();
            }
            catch (Exception err)
            {
                Console.WriteLine(err);
            }
        }

        /* DataGrid Changing */
        private void CreateTables(int number)
        {
            if (number < 1)
            {
                MessageBox.Show("프로세스의 개수가 올바르지 않습니다.", "범위값 에러", MessageBoxButton.OK, MessageBoxImage.Error, MessageBoxResult.OK);
            }

            Random rand = new Random();

            data.RemoveRange(0, data.Count);

            if (!ToggleCheck.IsChecked)
            {
                RightControl.PTHeader1.IsReadOnly = RightControl.PTHeader2.IsReadOnly = true;
            }

            for (int i = 0; i < number; i++)
            {
                if (ToggleCheck.IsChecked)
                    data.Add(new ProcessData() { no = "" + (i + 1), pid = "" + (1001 + i), priority = "" + rand.Next(8), arrived_time = "" + (rand.Next(10) + 1), service_time = "" + (rand.Next(10) + 1) });
                else
                    data.Add(new ProcessData() { no = "" + (i + 1), pid = "" + (1001 + i), priority = "", arrived_time = "", service_time = "" });
            }
            
            RightControl.ProcessTable.ItemsSource = data;
            RightControl.ProcessTable.Items.Refresh();
        }
    }

    /* ProcessCount TextBox에 대한 ViewModel */
    public class ProcCnt : INotifyPropertyChanged
    {
        public string processCount;

        public event PropertyChangedEventHandler PropertyChanged;

        public string ProcessCount
        {
            get { return processCount; }
            set {
                processCount = value;
                OnPropertyChanged("ProcessCount");
            }
        }


        protected void OnPropertyChanged(string name)
        {
            PropertyChangedEventHandler handler = PropertyChanged;

            if (handler != null)
            {
                handler(this, new PropertyChangedEventArgs(name));
            }
        }
    }

    public class ProcessData
    {
        public string no { get; set; }
        public string pid { get; set; }
        public string priority { get; set; }
        public string arrived_time { get; set; }
        public string service_time { get; set; }

        public ProcessData()
        {
            no = pid = priority = arrived_time = service_time = "";
        }
    }
}
