using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.ComponentModel.DataAnnotations;

namespace WIL_Project_v2.Pages
{
    public class Complaint_PageModel : PageModel
    {
        
         
            public string FirstName { get; set; } = "";

            public string LastName { get; set; } = "";

            [BindProperty]
            [Required(ErrorMessage = "The Email is required")]
            public string Email { get; set; } = "";

            [BindProperty]
            public string PhoneNumber { get; set; } = "";

            [BindProperty]
            [Required(ErrorMessage = "The Subject is required")]
            public string Subject { get; set; } = "";

            [BindProperty]
            [Required(ErrorMessage = "The Message is required")]
            public string Message { get; set; } = "";


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
                PhoneNumber = "";
                Subject = "";
                Message = "";

                ModelState.Clear();
            }
        }
    }
