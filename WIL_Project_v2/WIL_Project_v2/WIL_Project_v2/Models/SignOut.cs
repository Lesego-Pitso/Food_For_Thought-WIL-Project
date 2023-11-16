using Microsoft.AspNet.Identity;
using Microsoft.AspNetCore.Hosting.Server;
using Microsoft.AspNetCore.SignalR;
using Microsoft.Data.SqlClient;
using Microsoft.EntityFrameworkCore.Metadata.Internal;
using MySql.Data.MySqlClient;
using MySqlConnector;
using System.ComponentModel.DataAnnotations;
using static Microsoft.EntityFrameworkCore.DbLoggerCategory.Database;

namespace WIL_Project_v2.Models
{
    public class SignOut
    {
       [Key]
        public int Id { get; set; }
        public string? Email { get; set; }
        public string? Password { get; set; }
        public bool AuthenticationUser()
        {
            //This is where we store our Connection String:
            string connectionString = "Server = tcp:kenny - computer.database.windows.net,1433; Initial Catalog = donations; Persist Security Info = False; User ID = admin1; Password = Humbo = thurm2; MultipleActiveResultSets = False; Encrypt = True; TrustServerCertificate = False; Connection Timeout = 30;";
            try
            {
                using MySql.Data.MySqlClient.MySqlConnection connection = new MySql.Data.MySqlClient.MySqlConnection(connectionString);
                connection.Open();
                string query = "Select Count(*) From Details Where Email = @Email AND Password = @Password";
                using MySql.Data.MySqlClient.MySqlCommand cmd = new MySql.Data.MySqlClient.MySqlCommand(query, connection);
                cmd.Parameters.AddWithValue("@Email", Email);
                cmd.Parameters.AddWithValue("@Password", Password);

                int count = Convert.ToInt32(cmd.ExecuteScalar());
                return count > 0;
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
                return false;
            }

        }
    }
    
}
