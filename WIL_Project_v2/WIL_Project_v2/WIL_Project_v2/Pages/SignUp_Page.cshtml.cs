using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;
using System.Xml.Linq;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using WIL_Project_v2.Data;
using WIL_Project_v2.Models;

namespace WIL_Project_v2.Pages
{
    public class SignUp_PageModel : PageModel
    {



        [BindProperty]
        [Required(ErrorMessage = "The First Name is required")]
        public string FirstName { get; set; } = "";

        [BindProperty]
        [Required(ErrorMessage = "The Last Name is required")]
        public string LastName { get; set; } = "";

        [BindProperty]
        [Required(ErrorMessage = "The Email is required")]
        public string Email { get; set; } = "";

        [BindProperty]
        [Required(ErrorMessage = "Password is required")]
        public string Password { get; set; } = "";

        public string successMessage = "";
        public string errorMessage = "";
        public void OnGet()
        {
        }

        public void OnPost()
        {
            if (!ModelState.IsValid)
            {
                errorMessage = "Data validation failed";
                return;
            }

            successMessage = "Your message has been received";

            FirstName = "";
            LastName = "";
            Email = "";
            Password = "";
            

            ModelState.Clear();
        }

        // public SignUp_PageModel SignUp_Page { get; set; } = default!;





    }
}
